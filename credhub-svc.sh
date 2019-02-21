#!/bin/bash

cf service credhub-svc > /dev/null 2> /dev/null
if [[ $? -eq 0 ]]; then
    # sevice exists so update it
    cf update-service credhub-svc -c ./credhub-svc.json
else
    # service dotn't exists so create it
    cf create-service credhub default credhub-svc -c ./credhub-svc.json
fi

