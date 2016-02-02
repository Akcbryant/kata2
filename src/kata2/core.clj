(ns kata2.core
  (:require [clojure.string :as string]))

(defn version-vec [version-str]
  (string/split version-str #"\."))

(defn pad-vec [vec1 vec2]
  (let [difference (- (count vec2) (count vec1))]
    (if (<= difference 0) vec1
      (into [] (concat vec1 (repeat difference "0"))))))

(defn compare-vecs [version1 version2]
   (map #(cond (> (read-string %1) (read-string %2)) 1
                (= (read-string %1) (read-string %2)) 0
                :else -1) version1 version2))

(defn version-compare [version1 version2]
  (let [version1-vec (version-vec version1)
        version2-vec (version-vec version2)
        pad-version1 (pad-vec version1-vec version2-vec)
        pad-version2 (pad-vec version2-vec version1-vec)
        compare-list (compare-vecs pad-version1 pad-version2)
        filtered-list (filter #(not (zero? %)) compare-list)]
    (if (empty? filtered-list) 0
      (first filtered-list))))

