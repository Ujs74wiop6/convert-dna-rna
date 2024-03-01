(ns convert-dna-rna.core
  (:require [clojure.string :as string]))

(def dictionary-dna-rna
  "Mapa de conversão: DNA para RNA"
  {"G" "C"
   "C" "G"
   "T" "A"
   "A" "U"})

(defn convert-nucleotide
  "Conversor de um nucleotídeo específico de uma fita de DNA,
    em um nucleotídeo para uma fita de RNA"
  [dictionary nucleotide]
  (get dictionary (str nucleotide)))

(defn to-rna
  "Transcrever cada nucleotídeo de uma fita de DNA em seu complemento de RNA
   Argumentos: função para converter um nucleotídeo, string representando fita de DNA
   Retorno: string representando fita de RNA"
  [transcription dna]
  (string/join
   (map #(transcription dictionary-dna-rna %)
        dna)))

; Ex de Conversão: DNA > RNA 
; {1° dna-nucleotide, 2° dna-strand}

;(def dna-nucleotide "G")
;(convert-nucleotide dictionary-dna-rna dna-nucleotide)
;(def dna-strand "GCAT")
;(to-rna convert-nucleotide dna-strand)

(defn input-dna-ribbon []
  (println "Input ribbon DNA: ")
  (flush)
  (read-line))

(defn process-ribbon [] 
  (to-rna convert-nucleotide (input-dna-ribbon)))

(defn -main [] 
  (println "RNA:" (process-ribbon)))

(-main)