(ns leiningen.write-resources
  (:require [leinjacker.eval :refer [in-project]]
            [leiningen.compile :as compile]))

(defn write-resources
  "Write resources from classpath to files."
  [project & args]
  (in-project (dissoc project :prep-tasks)
    [resources (if args
                 (partition 2 args)
                 (:write-resources project))]
    (ns (:require [clojure.java.io :refer [copy resource file input-stream make-parents]]))
    (doseq [[source target] resources]
      (println "writing resource" source "to" target)
      (let [target-file (file target)]
        (make-parents target-file)
        (copy (input-stream (resource source)) target-file)))))

(defn compile-hook [task & [project :as args]]
  (write-resources project)
  (apply task args))

;; (defn activate []
;;   (hooke/add-hook #'compile/compile #'compile-hook))
