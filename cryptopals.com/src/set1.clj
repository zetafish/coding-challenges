(ns set1
  (:require [clojure.data.codec.base64 :as b64]))


(b64/encode (.getBytes "as"))

;; https://cryptopals.com/sets/1

(def digit->n
  (zipmap "0123456789abcdef"
          (range 16)))

(def s "49276d206b696c6c696e6720796f757220627261696e206c696b65206120706f69736f6e6f7573206d757368726f6f6d")

(defn hex->bytes
  [s]
  (->> (map digit->n s)
     (partition 2)
     (map (fn [[a b]] (+ (* 16 a) b)))
     (byte-array)))

(defn bytes->base64
  [b]
  (-> b b64/encode String.))

(def hex->base64 (comp bytes->base64 hex->bytes))
