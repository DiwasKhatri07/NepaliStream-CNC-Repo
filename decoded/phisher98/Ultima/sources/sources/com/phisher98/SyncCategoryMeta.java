package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/Ultima/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\t\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\u000e\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0003\u0010\b\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0007HÆ\u0003JQ\u0010\u0013\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\b\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0007HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR%\u0010\b\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000e¨\u0006\u001a"}, d2 = {"Lcom/phisher98/SyncCategoryMeta;", "", "ts", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "hash", "", "device", "<init>", "(JLjava/lang/String;Ljava/lang/String;)V", "getTs", "()J", "getHash", "()Ljava/lang/String;", "getDevice", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SyncCategoryMeta {

    @JsonProperty("device")
    @NotNull
    private final String device;

    @JsonProperty("hash")
    @NotNull
    private final String hash;

    @JsonProperty("ts")
    private final long ts;

    public SyncCategoryMeta() {
        this(0L, null, null, 7, null);
    }

    public static /* synthetic */ SyncCategoryMeta copy$default(SyncCategoryMeta syncCategoryMeta, long j, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            j = syncCategoryMeta.ts;
        }
        if ((i & 2) != 0) {
            str = syncCategoryMeta.hash;
        }
        if ((i & 4) != 0) {
            str2 = syncCategoryMeta.device;
        }
        return syncCategoryMeta.copy(j, str, str2);
    }

    /* JADX INFO: renamed from: component1, reason: from getter */
    public final long getTs() {
        return this.ts;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHash() {
        return this.hash;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDevice() {
        return this.device;
    }

    @NotNull
    public final SyncCategoryMeta copy(@JsonProperty("ts") long ts, @JsonProperty("hash") @NotNull String hash, @JsonProperty("device") @NotNull String device) {
        return new SyncCategoryMeta(ts, hash, device);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncCategoryMeta)) {
            return false;
        }
        SyncCategoryMeta syncCategoryMeta = (SyncCategoryMeta) other;
        return this.ts == syncCategoryMeta.ts && Intrinsics.areEqual(this.hash, syncCategoryMeta.hash) && Intrinsics.areEqual(this.device, syncCategoryMeta.device);
    }

    public int hashCode() {
        return (((SyncCategoryMeta$$ExternalSyntheticBackport0.m3m(this.ts) * 31) + this.hash.hashCode()) * 31) + this.device.hashCode();
    }

    @NotNull
    public String toString() {
        return "SyncCategoryMeta(ts=" + this.ts + ", hash=" + this.hash + ", device=" + this.device + ')';
    }

    public SyncCategoryMeta(@JsonProperty("ts") long ts, @JsonProperty("hash") @NotNull String hash, @JsonProperty("device") @NotNull String device) {
        this.ts = ts;
        this.hash = hash;
        this.device = device;
    }

    public /* synthetic */ SyncCategoryMeta(long j, String str, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? 0L : j, (i & 2) != 0 ? "" : str, (i & 4) != 0 ? "" : str2);
    }

    public final long getTs() {
        return this.ts;
    }

    @NotNull
    public final String getHash() {
        return this.hash;
    }

    @NotNull
    public final String getDevice() {
        return this.device;
    }
}
