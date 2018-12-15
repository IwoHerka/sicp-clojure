; Exercise 1.2 Translate the following expression
; into a prefix form.

(/ (+ 5 4 (- 2 (- 3 (+ 6 (/ 4 5)))))
   (* 3 (- 6 3) (- 3 7)))

; Exercise 1.3 Define a procedure that takes three numbers
; as arguments and returns the sum of the squares of the two
; larger numbers.

(defn larger-two [a b c]
  (cond
    (and (>= a b) (>= b c)) [a b]
    (and (>= b a) (>= c a)) [b c]
    :else [c a]))

(defn sum-of-squares [a b]
  (+ (* a a) (* b b)))

(defn sum-of-squares-of-larger-two [a b c]
  (apply sum-of-squares (larger-two a b c)))
