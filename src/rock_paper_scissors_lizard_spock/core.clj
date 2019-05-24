(ns rock-paper-scissors-lizard-spock.core
  (:gen-class)
  (:require [dynne.sampled-sound :refer :all]))

(def rules
    (read-sound "resources/rules_audio.mp3"))

(defn explain-rules []
  (println "The rules!")
  (play rules)
  (println "Need the rules again? (y/n)")
  (let [rules-repeat (read-line)]
    (cond
      (= rules-repeat "y")
        (do (explain-rules))
      (= rules-repeat "n")
        (do (println "Excellent!"))
      :else
        (do (explain-rules)))))

(defn setup-game []
  (println "Are you ready to play Rock Paper Scissors Lizard Spock? (y/n)")
  (let [response (read-line)]
    (cond
      (= response "y")
        (do (loop []
            (println "Do you know the rules? (y/n)")
            (let [rules-indication (read-line)]
            (cond
              (= rules-indication "n")
                (do (explain-rules))
              (= rules-indication "y")
                (do (println "Alright let's get right into a game!"))
              :else
                (recur))))
      (= response "n")
        (do (println "Alright, let us know when you are ready!"))
      :else
        (setup-game)))))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (setup-game))
