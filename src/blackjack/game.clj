(ns blackjack.game
  (:require [card-ascii-art.core :as card]))

(defn new-card
  "Generate a card number between 1 and 13"
  []
  (inc (rand-int 13)))

(defn player
  "Represents a player"
  [player-name]
  (let [card1 (new-card)
        card2 (new-card)]
    {:player-name player-name
     :cards [card1 card2]}))

(card/print-player (player "Arch"))
(card/print-player (player "Dealer"))