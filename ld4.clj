(ns ld4.core)

(defn averageMark
  [gradeMap]

  (def namesWithA (reduce into []
     (filter 
         #(= "a" (subs (first %) (- (count (first %)) 1))) gradeMap) 
     )
  )

  (def markSum (loop [sum 0 i 1]
      (if (>= i (count namesWithA))
             	sum
           	(recur (+ sum (nth namesWithA i)) (+ i 2))
			
			)
      )
  )       

  (print "Average mark:")
  (float (/ markSum (/ (count namesWithA) 2)))
)