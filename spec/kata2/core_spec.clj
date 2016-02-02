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

(describe "Pad version vectors"
  (it "[1 0 ] [1 0 0]"
    (should= ["1" "0" "0"] (pad-vec ["1" "0"] ["1" "0" "0"])))
  (it "[1] [1 2 3 4]"
    (should= ["1" "0" "0" "0"] (pad-vec ["1"] ["1" "2" "3" "4"]))))

(describe "Compare two vectors of numbers"
  (it "[1] [1]"
    (should= '(0) (compare-vecs ["1"]["1"])))
  (it "[1 0] [0 0 1]"
    (should= '(1 0) (compare-vecs ["1" "0"]["0" "0" "1"]))))

(describe "Compare two version strings"
  (it "1.2.3.4 and 2.3.4"
    (should= -1 (version-compare "1.2.3.4" "2.3.4")))
  (it "1 and 0"
    (should= 1 (version-compare "1" "0")))
  (it "0.0.0.1 and 0.1.0.2"
    (should= -1 (version-compare "0.0.3.1" "0.1.0.2")))
  (it "0.0.1 and 0.0.1"
    (should= 0 (version-compare "0.0.1" "0.0.1")))
  (it "1.2.3.4 and 1"
    (should= 1 (version-compare "1.2.3.4" "1"))))
