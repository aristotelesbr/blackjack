(ns blackjack.game-test
  (:require [clojure.test :refer :all]
            [blackjack.game :refer :all]))

(deftest test-new-card
  (testing "Must be generate a number gte 1"
    (is (>= (new-card) 1)))
  (testing "Must be generate a number lte 13"
    (is (<= (new-card) 13))))

(deftest test-player
  (testing "Must be return a valid players data"
    (let [player-map (player "Arch")]
      (is (= true (->
                   (and
                    (= (player-map :player-name) "Arch")
                    (= (count (player-map :cards)) 2))))))))

(deftest points-card-test
  (testing "When ginven 1 and 10 must be returs 21")
  (is (= 21 (points-card [1 10])))
  (testing "When ginven 1, 5 and 7 must be returs 13")
  (is (= 13 (points-card [1 5 7]))))
