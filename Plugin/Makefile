IOS_REPO_NAME := AdColony-iOS-SDK
UNITY_PLUGIN_DIR := $(shell pwd)
SDK_DIR := $(UNITY_PLUGIN_DIR)/src/sdks
IOS_DIR := $(SDK_DIR)/$(IOS_REPO_NAME)
ANDROID_FINAL_WRAPPER_DIR := $(UNITY_PLUGIN_DIR)/src/android
ANDROID_FINAL_WRAPPER_AAR := $(UNITY_PLUGIN_DIR)/src/android/Library/build/outputs/release/adcolony-wrapper.aar
UNITY_PACKAGE_FULL_PATH := $(UNITY_PLUGIN_DIR)/AdColony.unitypackage
UNITY_TEMP_PROJECT_DIR := $(UNITY_PLUGIN_DIR)/tempunitypackage
UNITY_BINARY := /Applications/Unity/Unity.app/Contents/MacOS/Unity
UNITY_LOG_FILE := $(UNITY_PACKAGE_FULL_PATH).build.log
PLUGIN_PACKAGE_FULL_PATH := $(UNITY_PLUGIN_DIR)/AdColony.unitypackage
# Version 1.2.164 - visit https://github.com/googlesamples/unity-jar-resolver for newer version if required
EXTERNAL_DEPENDENCY_MANAGER_PATH := $(UNITY_PLUGIN_DIR)/external-dependency-manager-latest.unitypackage

.PHONY: clean

all: unity

clean: clean_android clean_ios clean_unity

# ---- iOS ----

ios:
	@if [ ! -x "$(IOS_DIR)/AdColony.framework" ]; then \
		echo "\nERROR: AdColony iOS SDK not found\n"; \
		echo "Make sure you have a copy of the native repository in the Plugin/src/sdks directory, run: \n  cd "$(SDK_DIR)"\n  git clone https://github.com/AdColony/$(IOS_REPO_NAME).git\n"; \
		exit 1; \
	fi;

	@# Move to plugin folder
	rm -rf "$(UNITY_PLUGIN_DIR)/Assets/Plugins/iOS/AdColony/AdColony.framework"
	cp -r "$(IOS_DIR)/AdColony.framework" "$(UNITY_PLUGIN_DIR)/Assets/Plugins/iOS/AdColony"
	rm -rf "$(UNITY_PLUGIN_DIR)/Assets/Plugins/iOS/AdColony/AdColony.framework/Versions"

clean_ios:
	rm -rf "$(UNITY_PLUGIN_DIR)/Assets/Plugins/iOS/AdColony/AdColony.framework"

# ---- Android ----

android:
	cd "$(ANDROID_FINAL_WRAPPER_DIR)" && ./gradlew clean && ./gradlew makeAar
	@# Move to plugin folder
	mkdir -p "$(UNITY_PLUGIN_DIR)/Assets/Plugins/Android"
	cp "$(ANDROID_FINAL_WRAPPER_AAR)" "$(UNITY_PLUGIN_DIR)/Assets/Plugins/Android/adcolony-wrapper.aar"

clean_android:
	rm -rf "$(ANDROID_FINAL_WRAPPER_DIR)/build"
	rm -rf "$(ANDROID_FINAL_WRAPPER_DIR)/Library/build"
	rm -f "$(UNITY_PLUGIN_DIR)/Assets/Plugins/Android/adcolony-wrapper.aar"

# ---- Unity ----

unity_package:
	@echo "Logfile: $(UNITY_LOG_FILE)"
	@echo "Building Unity package: $(UNITY_PACKAGE_FULL_PATH)"
	@rm -rf "$(UNITY_PACKAGE_FULL_PATH)"
	@rm -rf "$(UNITY_TEMP_PROJECT_DIR)"
	@mkdir "$(UNITY_TEMP_PROJECT_DIR)"
	@cp -r "$(UNITY_PLUGIN_DIR)/Assets" "$(UNITY_TEMP_PROJECT_DIR)"

	@if [ ! -x "$(UNITY_BINARY)" ]; then \
		echo "\nERROR: $(UNITY_BINARY) not found\nYou might have to change the path of the Unity binary in the makefile, or move the Unity application to the default location."; exit 1; \
	fi;

	@if [ -x "$(UNITY_BINARY)" ]; then \
		"$(UNITY_BINARY)" \
		-gvh_disable \
		-batchmode \
		-quit \
		-force-free \
		-logFile "$(UNITY_LOG_FILE)" \
		-importPackage "$(EXTERNAL_DEPENDENCY_MANAGER_PATH)" \
		-projectPath "$(UNITY_TEMP_PROJECT_DIR)" \
		-exportPackage "Assets" "$(UNITY_PACKAGE_FULL_PATH)" \
		|| echo "ERROR: Error building unity package, see log: $(UNITY_LOG_FILE)"; \
	else \
		@echo "ERROR: Unity package not created, looked for Unity at $(UNITY_BINARY)."; \
	fi;

	@rm -rf "$(UNITY_TEMP_PROJECT_DIR)"

unity: android ios unity_package

clean_unity:
	rm -rf "$(UNITY_TEMP_PROJECT_DIR)"
	rm -f "$(UNITY_PACKAGE_FULL_PATH)"
	rm -f "$(UNITY_LOG_FILE)"
