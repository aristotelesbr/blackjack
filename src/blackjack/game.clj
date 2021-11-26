(ns blackjack.game)

(defn new-card []
  "Generate a card number between 1 and 13"
  (inc(rand-int 13)))
