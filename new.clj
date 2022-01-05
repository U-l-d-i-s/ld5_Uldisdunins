(ns new)
(defn pattern [rails]
  (concat (range rails)
          (drop 1 (range (dec rails) 0 -1))))
(defn railSecurity [type key text]
  (let
   [encrypt(->> (map vector (cycle (pattern key)) (range (count text)))
         (sort-by first)
         (map second)
         )
    decrypt (->> encrypt
                      (map-indexed vector)
                      (sort-by second)
                      (map first))]
    (cond
      (= type "encrypt")
      (apply str
             (map #(nth text %) encrypt))
      (= type "decrypt")
      (apply str
             (map #(nth text %) decrypt))
     )))
(railSecurity "encrypt" 4 "SveikiManiSaucUldis")
(railSecurity "decrypt" 4 "SMusviaacieknSUdiil")
