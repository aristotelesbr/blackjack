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
