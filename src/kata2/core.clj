(ns kata2.core
  (:require [clojure.string :as string]))

(defn version-vec [version-str]
  (string/split version-str #"\."))

(defn compare-versions [version1 version2]
  (map #(cond (> (read-string %1) (read-string %2)) 1
              (= (read-string %1) (read-string %2)) 0
              :else -1) version1 version2))
