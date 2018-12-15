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


; Exercise 1.7 The good-enough? test used in computing
; square roots will not be very effective for finding
; the square roots of very small number. Also, in real
; computers, arithmetic operations are almost always
; performed with limited precision. This makes our test
; inadequate for very large numbers. [...] An alternative
; strategy for implementing good-enough? is to watch how
; guess changes from one iteration to the next and to
; stop when the change is very small fraction of the guess.
; Design a square-root procedure that uses this kind of
; end test.

(defn abs [n]
  (if (pos? n) n (- 0 n)))

(defn improve [g n]
  (/ (+ g (/ n g)) 2))

(defn sqrt-iter [n guess E]
  (let [guess' (improve guess n)
        delta (abs (- guess guess'))]
      (if (< delta E)
        guess
        (sqrt-iter n guess' E))))

(defn sqrt [n E]
  "Calculate square root of n using Newton's method,
   where E is the desired precision."
  (sqrt-iter n (improve n n) E))
