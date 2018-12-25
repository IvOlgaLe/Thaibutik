package com.myapp.cache;

import com.myapp.DAO.OrderStateDAO;
import com.myapp.DAO.RoleDAO;
import com.myapp.exception.NotFoundException;
import com.myapp.model.OrderState;
import com.myapp.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.config.ConfigurableBeanFactory;
import org.springframework.context.annotation.DependsOn;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Scope;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantReadWriteLock;

@Lazy
@Service
@Scope(value = ConfigurableBeanFactory.SCOPE_SINGLETON)
//@DependsOn("dbPopulator")
public class CacheManager {

    RoleDAO roleDAO;

    OrderStateDAO orderStateDAO;

    private final ReentrantReadWriteLock readWriteLock = new ReentrantReadWriteLock();

    private final Lock readLock = readWriteLock.readLock();

    private final Lock writeLock = readWriteLock.writeLock();

    //maps for enums of data
    private int initCapacity = 500;
    private Map<String, String> enumIdToNameMap = new HashMap<String, String>(initCapacity);
    private Map<String, Integer> enumNameToIdMap = new HashMap<String, Integer>(initCapacity);

    @Autowired
    public CacheManager(@Autowired RoleDAO roleDAO, @Autowired OrderStateDAO orderStateDAO) {
        this.roleDAO = roleDAO;
        this.orderStateDAO = orderStateDAO;
        writeLock.lock();
        try {
            initCache();
        } finally {
            writeLock.unlock();
        }
    }

    private void initCache() {
        loadRoleValues();
        loadOrderStateValues();
    }

    private void loadRoleValues() {
        List<Role> roleList = roleDAO.getAllRoles();
        for (Role role : roleList) {
            int roleId = role.getId();
            String roleName = role.getName();
            enumIdToNameMap.put(MemoryCache.ROLE.getName() + "_" + roleId, roleName);
            enumNameToIdMap.put(MemoryCache.ROLE.getName() + "_" + roleName, roleId);
        }
    }

    private void loadOrderStateValues() {
        List<OrderState> orderStateList = orderStateDAO.getAllOrderStates();
        for (OrderState state : orderStateList) {
            int stateId = state.getId();
            String stateName = state.getName();
            enumIdToNameMap.put(MemoryCache.ORDER_STATE.getName() + "_" + stateId, stateName);
            enumNameToIdMap.put(MemoryCache.ORDER_STATE.getName() + "_" + stateName, stateId);

        }
    }

    public void clearCache() {
        writeLock.lock();
        try {
            enumIdToNameMap.clear();
            enumNameToIdMap.clear();
            initCache();
        } finally {
            writeLock.unlock();
        }
    }

    public int getEnumIdByName(String enumName, String fieldName) throws NotFoundException {
        readLock.lock();
        try {
            Integer fieldId = enumNameToIdMap.get(enumName + "_" + fieldName);
            if (fieldId == null)
                throw new NotFoundException("Enum not found by param: enumName=" + enumName + ", fieldName=" + fieldName);
            return fieldId;
        } finally {
            readLock.unlock();
        }
    }

    public String getEnumNameById(String enumName, int fieldId) throws NotFoundException {
        readLock.lock();
        try {
            String fieldName = enumIdToNameMap.get(enumName + "_" + fieldId);
            if (fieldName == null)
                throw new NotFoundException("Enum not found by param: enumName=" + enumName + ", fieldId=" + fieldId);
            return fieldName;
        } finally {
            readLock.unlock();
        }
    }

}
