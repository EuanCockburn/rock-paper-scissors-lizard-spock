(ns rock-paper-scissors-lizard-spock.enquiries
  (:gen-class))

(defn play-enquiry []
  (println "Would you like to play again? (y/n)")
  (let [play-enquiry-response (read-line)]
  (cond
    (= play-enquiry-response "y")
      true
    (= play-enquiry-response "n")
      false
    :else
      (play-enquiry))))

(defn rules-enquiry []
  (println "Do you know the rules? (y/n)")
  (let [rules-enquiry-response (read-line)]
  (cond
    (= rules-enquiry-response "n")
      true
    (= rules-enquiry-response "y")
      false
    :else
      (do (rules-enquiry)))))
