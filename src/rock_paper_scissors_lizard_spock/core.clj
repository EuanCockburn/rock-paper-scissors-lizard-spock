(ns rock-paper-scissors-lizard-spock.core
  (:gen-class)
  (:require [dynne.sampled-sound :refer :all]
            [rock-paper-scissors-lizard-spock
              [enquiries :as enquire]
              [play-game :as play]]))

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
        (do (play/game))
      :else
        (do (explain-rules)))))

(defn -main
  [& args]
  (if (play/setup-game) (if (enquire/rules-enquiry) (explain-rules) (play/game)) (println "Alright, let us know when you are ready!")))
