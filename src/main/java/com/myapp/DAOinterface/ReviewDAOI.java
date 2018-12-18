package com.myapp.DAOinterface;

public interface ReviewDAOI {
    enum SQL {
        INSERT_REVIEW("INSERT INTO review VALUES (?, ?, ?, ?, ?, ?)"),       //6 items
        GET_REVIEW_BY_ID("SELECT * FROM review WHERE review_id = ?"),
        GET_REVIEW_BY_USERID("SELECT * FROM review WHERE user_id = ?"),
        GET_ALL_REVIEWS("SELECT * FROM review"),
        DELETE_REVIEW_BY_ID("DELETE FROM review WHERE review_id = ?"),
        DELETE_REVIEW_BY_USERID("DELETE FROM review WHERE user_id = ?")
        ;

        private final String query;

        SQL(String s) {
            this.query = s;
        }

        public String getQuery() {
            return query;
        }
    }
}
