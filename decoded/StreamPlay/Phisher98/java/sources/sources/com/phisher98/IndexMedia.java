package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u0017\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B£\u0001\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007\u0012\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b\u0012\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t\u0012\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\n¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0014\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0015\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J¥\u0001\u0010\u001a\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00072\u0018\b\u0003\u0010\b\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\b2\u0018\b\u0003\u0010\t\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\t2\u0018\b\u0003\u0010\n\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\nHÆ\u0001J\u0014\u0010\u001b\u001a\u00020\u001c2\b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001e\u001a\u00020\u001fHÖ\u0081\u0004J\n\u0010 \u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\n\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000e¨\u0006!"}, d2 = {"Lcom/phisher98/IndexMedia;", "", "id", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "driveId", "mimeType", "size", "name", "modifiedTime", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getDriveId", "getMimeType", "getSize", "getName", "getModifiedTime", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class IndexMedia {

    @Nullable
    private final String driveId;

    @Nullable
    private final String id;

    @Nullable
    private final String mimeType;

    @Nullable
    private final String modifiedTime;

    @Nullable
    private final String name;

    @Nullable
    private final String size;

    public IndexMedia() {
        this(null, null, null, null, null, null, 63, null);
    }

    public static /* synthetic */ IndexMedia copy$default(IndexMedia indexMedia, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = indexMedia.id;
        }
        if ((i & 2) != 0) {
            str2 = indexMedia.driveId;
        }
        if ((i & 4) != 0) {
            str3 = indexMedia.mimeType;
        }
        if ((i & 8) != 0) {
            str4 = indexMedia.size;
        }
        if ((i & 16) != 0) {
            str5 = indexMedia.name;
        }
        if ((i & 32) != 0) {
            str6 = indexMedia.modifiedTime;
        }
        String str7 = str5;
        String str8 = str6;
        return indexMedia.copy(str, str2, str3, str4, str7, str8);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDriveId() {
        return this.driveId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getMimeType() {
        return this.mimeType;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getSize() {
        return this.size;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getModifiedTime() {
        return this.modifiedTime;
    }

    @NotNull
    public final IndexMedia copy(@JsonProperty("id") @Nullable String id, @JsonProperty("driveId") @Nullable String driveId, @JsonProperty("mimeType") @Nullable String mimeType, @JsonProperty("size") @Nullable String size, @JsonProperty("name") @Nullable String name, @JsonProperty("modifiedTime") @Nullable String modifiedTime) {
        return new IndexMedia(id, driveId, mimeType, size, name, modifiedTime);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof IndexMedia)) {
            return false;
        }
        IndexMedia indexMedia = (IndexMedia) other;
        return Intrinsics.areEqual(this.id, indexMedia.id) && Intrinsics.areEqual(this.driveId, indexMedia.driveId) && Intrinsics.areEqual(this.mimeType, indexMedia.mimeType) && Intrinsics.areEqual(this.size, indexMedia.size) && Intrinsics.areEqual(this.name, indexMedia.name) && Intrinsics.areEqual(this.modifiedTime, indexMedia.modifiedTime);
    }

    public int hashCode() {
        return ((((((((((this.id == null ? 0 : this.id.hashCode()) * 31) + (this.driveId == null ? 0 : this.driveId.hashCode())) * 31) + (this.mimeType == null ? 0 : this.mimeType.hashCode())) * 31) + (this.size == null ? 0 : this.size.hashCode())) * 31) + (this.name == null ? 0 : this.name.hashCode())) * 31) + (this.modifiedTime != null ? this.modifiedTime.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "IndexMedia(id=" + this.id + ", driveId=" + this.driveId + ", mimeType=" + this.mimeType + ", size=" + this.size + ", name=" + this.name + ", modifiedTime=" + this.modifiedTime + ')';
    }

    public IndexMedia(@JsonProperty("id") @Nullable String id, @JsonProperty("driveId") @Nullable String driveId, @JsonProperty("mimeType") @Nullable String mimeType, @JsonProperty("size") @Nullable String size, @JsonProperty("name") @Nullable String name, @JsonProperty("modifiedTime") @Nullable String modifiedTime) {
        this.id = id;
        this.driveId = driveId;
        this.mimeType = mimeType;
        this.size = size;
        this.name = name;
        this.modifiedTime = modifiedTime;
    }

    public /* synthetic */ IndexMedia(String str, String str2, String str3, String str4, String str5, String str6, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3, (i & 8) != 0 ? null : str4, (i & 16) != 0 ? null : str5, (i & 32) != 0 ? null : str6);
    }

    @Nullable
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getDriveId() {
        return this.driveId;
    }

    @Nullable
    public final String getMimeType() {
        return this.mimeType;
    }

    @Nullable
    public final String getSize() {
        return this.size;
    }

    @Nullable
    public final String getName() {
        return this.name;
    }

    @Nullable
    public final String getModifiedTime() {
        return this.modifiedTime;
    }
}
