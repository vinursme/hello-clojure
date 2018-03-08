(ns hello-clojure.datatypes.vectors)


;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;
;; 向量，类似C语言里面的数组
;; ;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;;

[3 2 1]

["a" "vector" "of" "string"]

;; 向量相关操作
;; 获取向量的第一个元素
(get [3 2 1] 0)

;; 获取向量的第二个元素
(get ["a" {:name "Pugsley Winterbottom"} "c"] 1)

;; 通过函数创建向量
(vector "creepy" "full" "moon")

;; 往向量里面增加一个元素，对于向量增加元素是加在结尾的
(def a [1 2 3])
(conj a 4)
;; 从这里可以看出，clojure里面的数据类型的值都是不可修改的，除非重新被赋值
a

;; vector本身也可以作为函数
([1 2 3] 2)

;; 越界了就会报错
;; ([1 2 3] 5)


(first [1 2 3 4])
(second [1 2 3 4])
(last [1 2 3 4])
(nth [1 2 3 4] 2)
(.get [1 2 3 4] 2)
