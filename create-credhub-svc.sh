#!/bin/bash

cf create-service credhub default credhub-svc -c '{"message":"Hello Cloud!","complex":{"foo":"==bat=="}}'