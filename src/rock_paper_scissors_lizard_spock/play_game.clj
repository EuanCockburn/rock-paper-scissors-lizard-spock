(ns rock-paper-scissors-lizard-spock.play-game
  (:gen-class)
  (:require [rock-paper-scissors-lizard-spock.enquiries :as enquire]))

(def matchings
  {
    "Rock"     ["Scissors" "Lizard"]
    "Paper"    ["Rock" "Spock"]
    "Scissors" ["Paper" "Lizard"]
    "Lizard"   ["Paper" "Spock"]
    "Spock"    ["Rock" "Scissors"]
  })

(defn game []
  (println "So, what do you pick?")
  (println "Rock, Paper, Scissors, Lizard or Spock?")
  (let [response (read-line)
        counter-pick (rand-nth (vec matchings))]
    (cond
      (contains? matchings response)
        (do (println (str "You picked: " response))
            (println (str "They picked: " (first counter-pick)))
            (cond
              (= response (first counter-pick))
                (do (println "It is a draw")
                    (if (enquire/play-enquiry) (game) (println "Alright, let us know when you are ready!")))
              (some #(= response %) (second counter-pick))
                (do (println "You have lost")
                    (if (enquire/play-enquiry) (game) (println "Alright, let us know when you are ready!")))
              :else
                (do (println "You have won")
                    (if (enquire/play-enquiry) (game) (println "Alright, let us know when you are ready!")))))
      :else
        (do (println "Sorry that choice isn't valid")
            (game)))))

(defn setup-game []
  (println "Are you ready to play Rock Paper Scissors Lizard Spock? (y/n)")
  (let [response (read-line)]
    (cond
      (= response "y")
        true
      (= response "n")
        false
      :else
        (setup-game))))
