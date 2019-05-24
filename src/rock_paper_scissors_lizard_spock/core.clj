(ns rock-paper-scissors-lizard-spock.core
  (:gen-class)
  (:require [dynne.sampled-sound :refer :all]))

(def rules
    (read-sound "resources/rules_audio.mp3"))

(defn explain-rules []
  (println "The rules!")
  (play rules)
  (println "Need the rules again? (y/n)")
  (let [response (read-line)]
    (cond
      (= response "y")
        (do (explain-rules))
      (= response "n")
        (do (println "Excellent!"))
      :else
        (do (explain-rules)))))

(defn rules-enquiry []
  (println "Do you know the rules? (y/n)")
  (let [response (read-line)]
  (cond
    (= response "n")
      (do (explain-rules))
    (= response "y")
      (do (println "Alright let's get right into a game!")))))

(defn setup-game []
  (println "Are you ready to play Rock Paper Scissors Lizard Spock? (y/n)")
  (let [response (read-line)]
    (cond
      (= response "y")
        (do (rules-enquiry))
      (= response "n")
        (do (println "Alright, let us know when you are ready!"))
      :else
        (setup-game))))

(defn -main
  [& args]
  (setup-game))
