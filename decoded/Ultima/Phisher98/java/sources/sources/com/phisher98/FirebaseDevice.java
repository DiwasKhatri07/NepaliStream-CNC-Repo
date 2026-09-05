package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0003\n\u0002\u0010\t\n\u0002\b\u0011\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0003\u0010\u0007\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\bHÆ\u0003JQ\u0010\u0018\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\u0007\u001a\u00020\b:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0003HÖ\u0081\u0004R-\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR-\u0010\u0006\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\f\"\u0004\b\u0010\u0010\u000eR-\u0010\u0007\u001a\u00020\b8\u0006@\u0006X\u0087\u000e\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u000e\n\u0000\u001a\u0004\b\u0011\u0010\u0012\"\u0004\b\u0013\u0010\u0014¨\u0006\u001f"}, d2 = {"Lcom/phisher98/FirebaseDevice;", "", "name", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "deviceId", "lastActive", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;J)V", "getName", "()Ljava/lang/String;", "setName", "(Ljava/lang/String;)V", "getDeviceId", "setDeviceId", "getLastActive", "()J", "setLastActive", "(J)V", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class FirebaseDevice {

    @JsonProperty("deviceId")
    @NotNull
    private String deviceId;

    @JsonProperty("lastActive")
    private long lastActive;

    @JsonProperty("name")
    @NotNull
    private String name;

    public FirebaseDevice() {
        this(null, null, 0L, 7, null);
    }

    public static /* synthetic */ FirebaseDevice copy$default(FirebaseDevice firebaseDevice, String str, String str2, long j, int i, Object obj) {
        if ((i & 1) != 0) {
            str = firebaseDevice.name;
        }
        if ((i & 2) != 0) {
            str2 = firebaseDevice.deviceId;
        }
        if ((i & 4) != 0) {
            j = firebaseDevice.lastActive;
        }
        return firebaseDevice.copy(str, str2, j);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDeviceId() {
        return this.deviceId;
    }

    /* JADX INFO: renamed from: component3, reason: from getter */
    public final long getLastActive() {
        return this.lastActive;
    }

    @NotNull
    public final FirebaseDevice copy(@JsonProperty("name") @NotNull String name, @JsonProperty("deviceId") @NotNull String deviceId, @JsonProperty("lastActive") long lastActive) {
        return new FirebaseDevice(name, deviceId, lastActive);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FirebaseDevice)) {
            return false;
        }
        FirebaseDevice firebaseDevice = (FirebaseDevice) other;
        return Intrinsics.areEqual(this.name, firebaseDevice.name) && Intrinsics.areEqual(this.deviceId, firebaseDevice.deviceId) && this.lastActive == firebaseDevice.lastActive;
    }

    public int hashCode() {
        return (((this.name.hashCode() * 31) + this.deviceId.hashCode()) * 31) + FirebaseDevice$$ExternalSyntheticBackport0.m1m(this.lastActive);
    }

    @NotNull
    public String toString() {
        return "FirebaseDevice(name=" + this.name + ", deviceId=" + this.deviceId + ", lastActive=" + this.lastActive + ')';
    }

    public FirebaseDevice(@JsonProperty("name") @NotNull String name, @JsonProperty("deviceId") @NotNull String deviceId, @JsonProperty("lastActive") long lastActive) {
        this.name = name;
        this.deviceId = deviceId;
        this.lastActive = lastActive;
    }

    public /* synthetic */ FirebaseDevice(String str, String str2, long j, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? "" : str2, (i & 4) != 0 ? 0L : j);
    }

    @NotNull
    public final String getName() {
        return this.name;
    }

    public final void setName(@NotNull String str) {
        this.name = str;
    }

    @NotNull
    public final String getDeviceId() {
        return this.deviceId;
    }

    public final void setDeviceId(@NotNull String str) {
        this.deviceId = str;
    }

    public final long getLastActive() {
        return this.lastActive;
    }

    public final void setLastActive(long j) {
        this.lastActive = j;
    }
}
