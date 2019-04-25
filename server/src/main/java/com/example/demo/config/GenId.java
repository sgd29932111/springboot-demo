package com.example.demo.config;

public interface GenId<T> {
    class NULL implements GenId {
        @Override
        public Object genId(String table, String column) {
            throw new UnsupportedOperationException();
        }
    }

    T genId(String table, String column);
}
