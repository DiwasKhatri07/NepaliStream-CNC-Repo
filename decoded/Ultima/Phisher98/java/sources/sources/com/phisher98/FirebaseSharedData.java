package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\u0012\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0007HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0007HÆ\u0003JU\u0010\u0018\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0019\u001a\u00020\u001a2\b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001c\u001a\u00020\u001dHÖ\u0081\u0004J\n\u0010\u001e\u001a\u00020\u0007HÖ\u0081\u0004R-\u0010\u0002\u001a\u00020\u00038\u0006@\u0006X\u0087\u000e\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\u000e\n\u0000\u001a\u0004\b\u000b\u0010\f\"\u0004\b\r\u0010\u000eR/\u0010\u0006\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\u000e\n\u0000\u001a\u0004\b\u000f\u0010\u0010\"\u0004\b\u0011\u0010\u0012R/\u0010\b\u001a\u0004\u0018\u00010\u00078\u0006@\u0006X\u0087\u000e\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u000e\n\u0000\u001a\u0004\b\u0013\u0010\u0010\"\u0004\b\u0014\u0010\u0012¨\u0006\u001f"}, d2 = {"Lcom/phisher98/FirebaseSharedData;", "", "lastUpdated", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "syncedData", "", "writerDevice", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getLastUpdated", "()J", "setLastUpdated", "(J)V", "getSyncedData", "()Ljava/lang/String;", "setSyncedData", "(Ljava/lang/String;)V", "getWriterDevice", "setWriterDevice", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class FirebaseSharedData {

    @JsonProperty("lastUpdated")
    private long lastUpdated;

    @JsonProperty("syncedData")
    @Nullable
    private String syncedData;

    @JsonProperty("writerDevice")
    @Nullable
    private String writerDevice;

    public FirebaseSharedData() {
        this(0L, null, null, 7, null);
    }

    public static /* synthetic */ FirebaseSharedData copy$default(FirebaseSharedData firebaseSharedData, long j, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = firebaseSharedData.lastUpdated;
        }
        if ((i & 2) != 0) {
            str = firebaseSharedData.syncedData;
        }
        if ((i & 4) != 0) {
            str2 = firebaseSharedData.writerDevice;
        }
        return firebaseSharedData.copy(j, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getLastUpdated() {
        return this.lastUpdated;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getSyncedData() {
        return this.syncedData;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getWriterDevice() {
        return this.writerDevice;
    }

    @NotNull
    public final FirebaseSharedData copy(@JsonProperty("lastUpdated") long lastUpdated, @JsonProperty("syncedData") @Nullable String syncedData, @JsonProperty("writerDevice") @Nullable String writerDevice) {
        return new FirebaseSharedData(lastUpdated, syncedData, writerDevice);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof FirebaseSharedData)) {
            return false;
        }
        FirebaseSharedData firebaseSharedData = (FirebaseSharedData) other;
        return this.lastUpdated == firebaseSharedData.lastUpdated && Intrinsics.areEqual(this.syncedData, firebaseSharedData.syncedData) && Intrinsics.areEqual(this.writerDevice, firebaseSharedData.writerDevice);
    }

    public int hashCode() {
        return (((FirebaseSharedData$$ExternalSyntheticBackport0.m2m(this.lastUpdated) * 31) + (this.syncedData == null ? 0 : this.syncedData.hashCode())) * 31) + (this.writerDevice != null ? this.writerDevice.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "FirebaseSharedData(lastUpdated=" + this.lastUpdated + ", syncedData=" + this.syncedData + ", writerDevice=" + this.writerDevice + ')';
    }

    public FirebaseSharedData(@JsonProperty("lastUpdated") long lastUpdated, @JsonProperty("syncedData") @Nullable String syncedData, @JsonProperty("writerDevice") @Nullable String writerDevice) {
        this.lastUpdated = lastUpdated;
        this.syncedData = syncedData;
        this.writerDevice = writerDevice;
    }

    public /* synthetic */ FirebaseSharedData(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? null : str, (i & 4) != 0 ? null : str2);
    }

    public final long getLastUpdated() {
        return this.lastUpdated;
    }

    public final void setLastUpdated(long j) {
        this.lastUpdated = j;
    }

    @Nullable
    public final String getSyncedData() {
        return this.syncedData;
    }

    public final void setSyncedData(@Nullable String str) {
        this.syncedData = str;
    }

    @Nullable
    public final String getWriterDevice() {
        return this.writerDevice;
    }

    public final void setWriterDevice(@Nullable String str) {
        this.writerDevice = str;
    }
}
