(ns blackjack.game-test
  (:require [clojure.test :refer :all]
            [blackjack.game :refer :all]))

(deftest new-card-test
  (testing "Must be generate a number gte 1"
    (is (>= (new-card) 1)))
  (testing "Must be generate a number lte 13"
    (is (<= (new-card) 13))))