(ns rs-clj.io
  (:require [clojure.core.matrix :refer [reshape]]
            [clojure.java.io :refer [input-stream]]
            [nio.core :as nio])
  (:import [org.apache.commons.io IOUtils]
           [java.nio ByteBuffer]))

(defn raw-read
  "Read every byte in file to heap ByteBuffer"
  [f & {:keys [endian] or {endian :little-endian}}]
  (let [channel (nio/channel f)
        size (.size channel)
        buf (ByteBuffer/allocate size)]
        (.read channel buf 0)
        (nio/set-byte-order! buf endian)
        buf))

(defn slurp-binary
  "Slurp binary file of shorts into array. TODO: expand to
  accept other data types."
  [f & {:keys [endian] or {endian :little-endian}}]
  (let [bbuf (.asShortBuffer (.flip (raw-read f :endian endian)))
        coerce '.asShortBuffer
        maker short-array
        buf (coerce bbuf)
        arr (maker (.limit buf))]
    (.get buf arr)
   arr))

(defn slurp-image
  [f dims & {:keys [endian] or {endian :little-endian}}]
  (reshape (slurp-binary f :endian endian) dims))

(defn raw-dump
  "Dump every byte in bstream into file"
  [bstream f]
  nil)

(comment

  ; WIP notes will go here
  (require 'rs-clj.io)
  (in-ns 'rs-clj.io)

  ; simple bsq image
  (def _ramp (reshape (range 100000) [100 100 10]))

  (def nireland
    (slurp-image "data/nireland.dat" [472 682 128]))
)
