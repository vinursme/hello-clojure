(ns hello-clojure.db.hugsql_example.quotes
  (:require [hugsql.core :as hugsql]))

(hugsql/def-db-fns "hello_clojure/db/sql/quotes.sql")

(hugsql/def-sqlvec-fns "hello_clojure/db/sql/quotes.sql")