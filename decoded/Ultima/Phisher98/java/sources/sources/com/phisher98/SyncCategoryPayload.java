package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: UltimaSettingsSyncUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/Ultima/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000.\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0002\n\u0002\u0010\t\n\u0002\b\r\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BO\u0012\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0016\b\u0003\u0010\b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\u0004\b\t\u0010\nJ\t\u0010\u0010\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0011\u001a\u00020\u0007HÆ\u0003J\t\u0010\u0012\u001a\u00020\u0003HÆ\u0003JQ\u0010\u0013\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0016\b\u0003\u0010\u0006\u001a\u00020\u0007:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0016\b\u0003\u0010\b\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\bHÆ\u0001J\u0014\u0010\u0014\u001a\u00020\u00152\b\u0010\u0016\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0017\u001a\u00020\u0018HÖ\u0081\u0004J\n\u0010\u0019\u001a\u00020\u0003HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\fR%\u0010\u0006\u001a\u00020\u00078\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR%\u0010\b\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\f¨\u0006\u001a"}, d2 = {"Lcom/phisher98/SyncCategoryPayload;", "", "data", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "ts", "", "device", "<init>", "(Ljava/lang/String;JLjava/lang/String;)V", "getData", "()Ljava/lang/String;", "getTs", "()J", "getDevice", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "Ultima"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class SyncCategoryPayload {

    @JsonProperty("data")
    @NotNull
    private final String data;

    @JsonProperty("device")
    @NotNull
    private final String device;

    @JsonProperty("ts")
    private final long ts;

    public SyncCategoryPayload() {
        this(null, 0L, null, 7, null);
    }

    public static /* synthetic */ SyncCategoryPayload copy$default(SyncCategoryPayload syncCategoryPayload, String str, long j, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = syncCategoryPayload.data;
        }
        if ((i & 2) != 0) {
            j = syncCategoryPayload.ts;
        }
        if ((i & 4) != 0) {
            str2 = syncCategoryPayload.device;
        }
        return syncCategoryPayload.copy(str, j, str2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getData() {
        return this.data;
    }

    /* JADX INFO: renamed from: component2, reason: from getter */
    public final long getTs() {
        return this.ts;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getDevice() {
        return this.device;
    }

    @NotNull
    public final SyncCategoryPayload copy(@JsonProperty("data") @NotNull String data, @JsonProperty("ts") long ts, @JsonProperty("device") @NotNull String device) {
        return new SyncCategoryPayload(data, ts, device);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SyncCategoryPayload)) {
            return false;
        }
        SyncCategoryPayload syncCategoryPayload = (SyncCategoryPayload) other;
        return Intrinsics.areEqual(this.data, syncCategoryPayload.data) && this.ts == syncCategoryPayload.ts && Intrinsics.areEqual(this.device, syncCategoryPayload.device);
    }

    public int hashCode() {
        return (((this.data.hashCode() * 31) + SyncCategoryPayload$$ExternalSyntheticBackport0.m4m(this.ts)) * 31) + this.device.hashCode();
    }

    @NotNull
    public String toString() {
        return "SyncCategoryPayload(data=" + this.data + ", ts=" + this.ts + ", device=" + this.device + ')';
    }

    public SyncCategoryPayload(@JsonProperty("data") @NotNull String data, @JsonProperty("ts") long ts, @JsonProperty("device") @NotNull String device) {
        this.data = data;
        this.ts = ts;
        this.device = device;
    }

    public /* synthetic */ SyncCategoryPayload(String str, long j, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? "" : str, (i & 2) != 0 ? 0L : j, (i & 4) != 0 ? "" : str2);
    }

    @NotNull
    public final String getData() {
        return this.data;
    }

    public final long getTs() {
        return this.ts;
    }

    @NotNull
    public final String getDevice() {
        return this.device;
    }
}
