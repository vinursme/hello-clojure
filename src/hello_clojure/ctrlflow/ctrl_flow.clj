(ns hello-clojure.ctrlflow.ctrl-flow
  ;; 导入clojure.set库
  (:require [clojure.repl :as r :refer [doc]]
            [clojure.set])
  )


;; clojure控制流

*ns*


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; if
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(if true
  "By Zeus's hammer!"
  "By Aquaman's trident!")

(if false
  "By Zeus's hammer!"
  "By Aquaman's trident!")

;; 如果没有设置else部分，那么if直接返回nil
(if false
  "By Odin's Elbow!")


;; do执行多行语句，返回最后一个语句的返回值
(if true
  (do (println "Success!")
      "By Zeus's hammer!")
  (do (println "Failure!")
      "By Aquaman's trident!"))


;; clojure里面的逻辑真跟逻辑假包含哪些？
;; true表示真，false表示假
;; nil一般情况下表示什么值都没有，但是在逻辑谓词中表示逻辑假
;; 所以nil跟false表示逻辑假，别的都表示为逻辑真
;; ()表示空列表，但是在逻辑测试表达式里面表示逻辑真
;; 那么clojure有哪些逻辑测试表达式呢？
;; 有if/and/or/when/=/</>/not/
;; 也就是说，对于逻辑测试表达式，只可能返回四种值，false/nil/true/其它

;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; not
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(not nil)
(not ())
(doc not)
(if (not ())
  true
  false)
(and () 1)


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; when
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(when nil
  "nothing")

;; 这里()就是表示真
(when ()
  "()")

;; 这里说明()在逻辑表达式里面表示真
(or nil ())
(or () nil)

(if (not nil)
  true
  false)
(false? ())
(false? nil)

(doc false?)

;; when，当判断条件为真的时候，就执行下面的语句，相当于if and do的结合，可以用来执行多条语句
;; 当判断条件为假的时候就返回nil
(when true
  (println "Success!")
  "abra cadabra")

;; 对于clojure而言，有true和false，nil用来表示什么值都没有，也就是说nil跟false不是一样的
;; 但是nil跟false都用来表示逻辑假，其它的值的字面值都表示逻辑真
;; 但是nil跟false字面上的值并不相等
(if "bears eat beets"
  "bears beets Battlestar Galactica")

(if nil
  "This won't be the result because nil is falsey"
  "nil is falsey")

(nil? 1)
(nil? nil)
(nil? false)


(false? false)
(false? nil)

(true? "h")

(= 1 1)
;; => true

(= nil nil)
;; => true

;; =>:large_I_mean_venti
(or false nil :large_I_mean_venti :why_cant_I_just_say_large)

;; => false
(or (= 0 1) (= "yes" "no"))

;; => 3
(or (= 0 1) (= "yes" "no") 3)

;; => nil
(or nil)

;; => false
(or nil false)

;; 总结一下or的行为:
;; 判断后面的每一个测试语句，直到遇到true的语句，返回他的值
;; 如果一直遇不到为true的测试语句，那么返回最后一个语句的返回值


;; => :hot_coffee
(and :free_wifi :hot_coffee)

;; => nil
(and :feelin_super_cool nil false)

;; => false
(and :feelin_super_cool false nil)

(false? nil)

;; 总结一下and的行为:
;; 判断后面的每一条语句，直到遇到一个值为false的，然后返回这条语句的值，其实返回值要么是nil要么是false
;; 如果一直遇到不为false的语句，那么返回最后一条语句的值


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; let
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

(let [x 3] x)
;; => 3

(def dalmatian-list
  ["Pongo" "Perdita" "Puppy 1" "Puppy 2"])

(let [dalmatians (take 2 dalmatian-list)]
  dalmatians)
;; => ("Pongo" "Perdita")


(def x 0)
;; let引入了一个新的作用域
(let [x 1] x)
;; => 1

(def x 0)
;; let里面引用已经定义的全局变量
(let [x (inc x)] x)
;; => 1

;; let的解构用法，参见解构部分
(let [[pongo & dalmatians] dalmatian-list]
  [pongo dalmatians])
;; => ["Pongo" ("Perdita" "Puppy 1" "Puppy 2")]



;; 逻辑值
;; clojure里面的true跟false就是java里面的boolen类型
(class true)
(class false)

;; 如果一个函数返回boolen值，那么起名的时候最好就以问号结尾
(true? true)
(true? false)
(false? false)
(false? true)
(nil? nil)
(nil? 1)

(not true)
(not false)
(not 1)
(not nil)
(not "hi")

(= :drinkme :drinkme)
(= :drinkme 4)

(= '(:drinkme :bottle) [:drinkme :bottle])
(not= :drinkme 4)


;; 流控制
(if true "it is true"
    ;; else
    "it is false")

(if false "it is true"
    ;; else
    "it is false")

(if nil "it is true"
    ;; else
    "it is false")

(if 1 "it is true"
    ;; else
    "it is false")
(if '() "it is true"
    ;; else
    "it is false")
;; 所以只有nil跟false是false

(if (= :drinkme :drinkme)
  "Try it"
  "Dont't try it")


(let [need-to-grow-small (> 5 3)]
  (if need-to-grow-small
    "drink bottle"
    "don't drink bottle"))

;; 将一个boolen绑定到一个符号，如果为真，那么执行第一条语句；否则执行第二条语句
(if-let [need-to-grow-small (> 5 3)]
  "drink bottle"
  "don't drink bottle")

;; when，当一个条件为真的时候才执行下面的语句
(defn drink [need-to-grow-small]
  (when need-to-grow-small
    "drink bottle"))
(drink true)
(drink nil)

(when-let [need-to-grow-small true]
  "drink bottle")
(when-let [need-to-grow-small false]
  "drink bottle")

;; cond测试更多的条件，一旦一个测试返回true，其它的测试子句都不会被尝试
(let [bottle "drinkme"]
  (cond
    (= bottle "poison") "don't touch"
    (= bottle "drinkme") "grow smaller"
    (= bottle "empty") "all gone"))


(let [x 2]
  (cond
    (> x 10) "bigger than 10"
    (> x 4) "bigger than 4"
    (> x 3) "bigger than 3"
    :else "< 3"))
