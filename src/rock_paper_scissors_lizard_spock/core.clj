(ns rock-paper-scissors-lizard-spock.core
  (:gen-class))

(defn -main
  "I don't do a whole lot ... yet."
  [& args]
  (loop []
  (println "Are you ready to play Rock Paper Scissors Lizard Spock? (y/n)")
  (let [response (read-line)]
    (cond (= response "y")
              (do (println "Do you know the rules? (y/n)"))
          (= response "n")
              (do (println "Alright, let us know when you are ready!"))
          :else
            (recur)))))
