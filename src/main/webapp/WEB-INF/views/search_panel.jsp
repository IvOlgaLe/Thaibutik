<div class="row list-view-sorting clearfix">
    <div class="col-md-10 col-sm-10">
        <div class="pull-left">
            <label class="control-label">Show&nbsp;by&nbsp;price:</label>
            <div class="pull-left">
                <input name="lowPrice" type="number" tabindex="1"/> -
                <input name="highPrice" type="number" tabindex="2"/>
            </div>
        </div>
        <div class="pull-left">
            <label class="control-label">Sort&nbsp;By:</label>
            <select name="orderBy" class="form-control input-sm">
                <option value="i.price*(1-i.discount/100)" selected="selected">Default</option>
                <option value="p.name">Name (A - Z)</option>
                <option value="p.name DESC">Name (Z - A)</option>
                <option value="i.price*(1-i.discount/100)">Price (Low &gt; High)</option>
                <option value="i.price*(1-i.discount/100) DESC">Price (High &gt; Low)</option>
            </select>
        </div>
    </div>
    <div class="col-md-10 col-sm-10">
        <div class="pull-left">
            <label class="control-label">Type:</label>
            <input name="itemType" type="text" tabindex="3"/>
        </div>
        <div class="pull-left">
            <label class="control-label">Size:</label>
            <input name="itemSize" type="text" tabindex="4"/>
        </div>
        <div class="pull-left">
            <label class="control-label">Brand:</label>
            <select name="brandId">
                <option value="">Select</option>
                <c:forEach var="brand" items="${brandList}">
                    <option value="${brand.id}">${brand.name}</option>
                </c:forEach>
            </select>
        </div>
        <div class="pull-left">
            <input name="applyFilter" type="hidden" value="true"/>
            <c:if test="${not empty searchWord}">
                <input name="name" type="hidden" value="${searchWord}"/>
            </c:if>
            <c:if test="${not empty category.id}">
                <input name="categoryId" type="hidden" value="${category.id}"/>
            </c:if>
            <button class="btn btn-primary" type="submit">Apply</button>
        </div>
    </div>
</div>
