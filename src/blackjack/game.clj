(ns blackjack.game
  (:require [card-ascii-art.core :as card]))

(defn new-card
  "Generate a card number between 1 and 13"
  []
  (inc (rand-int 13)))

(defn JQK->10
  "Replace J, Q and K per 10"
  [card]
  (if (> card 10) 10 card))

(defn A->11
  "Replace A per 11"
  [card]
  (if (= card 1) 11 card))

;; "J Q K must be equals 10"
;; "[A 10] = 11 or 21 = 21"
;; "[A 5 7] = 1+5+7 (13) or 11+5+7 (23)"
;; "A = 11 if > 21 A = 1"
(defn points-card
  "Calculate points according to cards"
  [cards]
  (let [cards-witout-JQK (map JQK->10 cards)
        cards-with-A11 (map A->11 cards-witout-JQK)
        points-with-A-1 (reduce + cards-witout-JQK)
        points-with-A-11 (reduce + cards-with-A11)]
    (if (> points-with-A-11 21) points-with-A-1 points-with-A-11)))

(points-card [1 10])
(points-card [1 5 7])
(points-card [1 5 5])

(defn player
  "Represents a player"
  [player-name]
  (let [card1 (new-card)
        card2 (new-card)
        cards [card1 card2]
        points (points-card cards)]
    {:player-name player-name
     :cards cards
     :points points}))

(card/print-player (player "Arch"))
(card/print-player (player "Dealer"))