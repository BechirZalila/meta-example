require recipes-core/images/core-image-base.bb

# This image require the following layers to be added:
# meta                  poky/meta
# meta-poky             poky/meta-poky
# meta-yocto-bsp        poky/meta-yocto-bsp
# meta-raspberrypi      meta-raspberrypi
# meta-example          *** This Layer ***
# meta-oe               meta-openembedded/meta-oe
# meta-python           meta-openembedded/meta-python
# meta-networking       meta-openembedded/meta-networking

# Also, some of the recipes require systemd to be the init process. So in
# local.conf, the following option should be added:
#
# DISTRO_FEATURES_append = " systemd"
# VIRTUAL-RUNTIME_init_manager = "systemd"
# DISTRO_FEATURES_BACKFILL_CONSIDERED = "sysvinit"
# VIRTUAL-RUNTIME_initscripts = ""

DESCRIPTION = "Image personnalisée avec clavier azerty et plein \
              d'autres fonctionnalités"

# Extra tools for all machines
IMAGE_INSTALL_append = " bridge-utils hostapd dhcp-server iptables dropbear busybox"
IMAGE_INSTALL_append = " bbexample azertykbd-systemd newuser"

# Raspberry Pi specific options:
DISTRO_FEATURES_raspberrypi3 += " bluez5 bluetooth wifi"
IMAGE_INSTALL_raspberrypi3_append = " linux-firmware-bcm43430 bluez5 i2c-tools python-smbus wpa-supplicant"
GPU_MEM_raspberrypi3 = "16"

#Custom password for root and pi
inherit extrausers
EXTRA_USERS_PARAMS = "\
         usermod -P raspberry root; \
         usermod -P raspberry pi; \
         "

LICENCE = "MIT"
