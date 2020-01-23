(ns ld5.core
   (:require [clojure.string :as str])	
  )


(defn encrypt [string cipherKey]
  (def result "")
  (def step (- (* cipherKey 2) 2))
  (def charVector (str/split (str/replace string " " "_") #""))
  (def stringSize (count string))
  
  (println "String To Encrypt:" string)

  (loop [i 0]
    (loop [j 0]
      (when (< j stringSize)
        (when (or (= 0 (mod (+ j i) step)) (= 0 (mod (- j i) step)))
						    (def result (str/join [result (nth charVector j)]))
        )
        (recur (inc j))
      )
    )
    (when (< i (- cipherKey 1))
	     (recur (inc i))
		  )
  )
  (println "Encrypted String:" result)
  (println)
)




(defn decrypt [string cipherKey]

  (def result "")
  (def charVector (str/split (str/replace string " " "_") #""))
  (def stringSize (count string)) 

  (def step (- (* cipherKey 2) 2))
  (def stepsCount (int (Math/floor (/ stringSize step))))
  (def extraSteps (mod stringSize step))


  (def steps
    (loop [i 1 vector []]
      (if (> i cipherKey)
        vector
        (recur (inc i)
          (conj vector
            (+
              (if (or (= i 1) (= i cipherKey))
                stepsCount
                (* stepsCount 2)
              )
              (if (> extraSteps cipherKey)
                (if (and (>= extraSteps (- (* 2 cipherKey) i))(not= i cipherKey)) 2 1)
                (if (>= extraSteps i) 1 0)
              )
            )
          )
        )
      )
    )
  )

  (println "String to decrypt:" string)
  (print "Dectypred String: ")

  (loop [i 0]
    (loop [j 1 x i]
      (when (< x stringSize)
        (print (nth charVector x))
      )
      (when (or (and (< i stepsCount) (< j step)) (and (= i stepsCount)(< j extraSteps)))
        (recur
          (inc j)
          (+ 
            (cond

              (< j cipherKey)
                (+ x (nth steps (- (if (>= j cipherKey) (- (* 2 cipherKey) j) j) 1)))


              (= j cipherKey)
                (+ 1 (- x (nth steps (- (if (>= j cipherKey) (- (* 2 cipherKey) j) j) 2))))


              (> j cipherKey)
                (- x (nth steps (- (if (>= j cipherKey) (- (* 2 cipherKey) j) j) 2)))
            )
            (cond
              (and (not= i 0)(= j (- cipherKey 1)))
                (- i)
              (and (not= i 0)(or (= j cipherKey)(= j 1)))
                i
              :else
                0
            )
          )
        )
      )
    )
    (when (if (< 0 extraSteps) (< i stepsCount) (< i (- stepsCount 1)))
      (recur (inc i))
    )
  )
)

(encrypt "This is a test" 3) 
(decrypt "Leetc eseh pintswgt  tdyouiion si ernfo riufc nk" 5)
