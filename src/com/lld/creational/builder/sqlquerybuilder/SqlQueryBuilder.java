package com.lld.creational.builder.sqlquerybuilder;

public class SqlQueryBuilder {
    public static void main(String [] args){
        SqlQuery query1 = new SqlQuery.Builder("users")
                .select("id", "name", "email")
                .where("age > 18")
                .where("active = true")
                .orderBy("name", "ASC")
                .limit(10)
                .build();

        SqlQuery query2 = new SqlQuery.Builder("orders")
                .select("id", "total", "created_at")
                .where("status = 'completed'")
                .where("total > 100")
                .orderBy("created_at", "DESC")
                .limit(20)
                .offset(40)
                .build();

        System.out.println(query1.toSql());
        System.out.println(query2.toSql());
    }
}
