(ns kata2.core-spec
  (:require [speclj.core :refer :all]
            [kata2.core :refer :all]))

(describe "Return a vector of the version number"
  (it "1"
    (should= ["1"] (version-vec "1")))
  (it "1.0.0"
    (should= ["1" "0" "0"] (version-vec "1.0.0")))
  (it "2.3.4.5.6"
    (should= ["2" "3" "4" "5" "6"] (version-vec "2.3.4.5.6"))))

(describe "Compare two vectors of numbers"
  (it "[1] [1]"
    (should= 0 (compare-versions ["1"]["1"])))
  (it "[1 0] [0 0 1]"
    (should= 1 (compare-versions ["1" "0"]["0" "0" "1"]))))
