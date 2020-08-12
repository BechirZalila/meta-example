DESCRIPTION = "Setup a default (French) keyboard-layout for the console only"
LICENSE = "MIT"
LIC_FILES_CHKSUM = "file://${COREBASE}/LICENSE;md5=b97a012949927931feb7793eee5ed924"

RDEPENDS_${PN} = "keymaps kbd-keymaps"

FILESEXTRAPATHS_prepend := "${THISDIR}/files:"

inherit systemd

SRC_URI = "file://kbdlayout.service"

do_install () {
    install -d ${D}${base_libdir}/systemd/system
    install -m 0644 ${WORKDIR}/kbdlayout.service ${D}${base_libdir}/systemd/system/
}

NATIVE_SYSTEMD_SUPPORT = "1"
SYSTEMD_PACKAGES = "${PN}"
SYSTEMD_SERVICE_${PN} = "kbdlayout.service"

FILES_${PN} += "${base_libdir}/systemd"
