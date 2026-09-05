package com.IStreamFlare;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: IStreamFlareParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/IStreamFlare/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0010\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B-\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0011\u001a\u0004\u0018\u00010\u0003HÆ\u0003J7\u0010\u0012\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\u0013\u001a\u00020\u00142\b\u0010\u0015\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0016\u001a\u00020\u0017HÖ\u0081\u0004J\n\u0010\u0018\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000b\u0010\nR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\nR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0019"}, d2 = {"Lcom/IStreamFlare/LoadDataObject;", "", "id", "", "tmdbId", "contentType", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getTmdbId", "getContentType", "getUrl", "component1", "component2", "component3", "component4", "copy", "equals", "", "other", "hashCode", "", "toString", "IStreamFlare"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class LoadDataObject {

    @Nullable
    private final String contentType;

    @NotNull
    private final String id;

    @Nullable
    private final String tmdbId;

    @Nullable
    private final String url;

    public static /* synthetic */ LoadDataObject copy$default(LoadDataObject loadDataObject, String str, String str2, String str3, String str4, int i, Object obj) {
        if ((i & 1) != 0) {
            str = loadDataObject.id;
        }
        if ((i & 2) != 0) {
            str2 = loadDataObject.tmdbId;
        }
        if ((i & 4) != 0) {
            str3 = loadDataObject.contentType;
        }
        if ((i & 8) != 0) {
            str4 = loadDataObject.url;
        }
        return loadDataObject.copy(str, str2, str3, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getTmdbId() {
        return this.tmdbId;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContentType() {
        return this.contentType;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final LoadDataObject copy(@NotNull String id, @Nullable String tmdbId, @Nullable String contentType, @Nullable String url) {
        return new LoadDataObject(id, tmdbId, contentType, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof LoadDataObject)) {
            return false;
        }
        LoadDataObject loadDataObject = (LoadDataObject) other;
        return Intrinsics.areEqual(this.id, loadDataObject.id) && Intrinsics.areEqual(this.tmdbId, loadDataObject.tmdbId) && Intrinsics.areEqual(this.contentType, loadDataObject.contentType) && Intrinsics.areEqual(this.url, loadDataObject.url);
    }

    public int hashCode() {
        return (((((this.id.hashCode() * 31) + (this.tmdbId == null ? 0 : this.tmdbId.hashCode())) * 31) + (this.contentType == null ? 0 : this.contentType.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "LoadDataObject(id=" + this.id + ", tmdbId=" + this.tmdbId + ", contentType=" + this.contentType + ", url=" + this.url + ')';
    }

    public LoadDataObject(@NotNull String id, @Nullable String tmdbId, @Nullable String contentType, @Nullable String url) {
        this.id = id;
        this.tmdbId = tmdbId;
        this.contentType = contentType;
        this.url = url;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @Nullable
    public final String getTmdbId() {
        return this.tmdbId;
    }

    @Nullable
    public final String getContentType() {
        return this.contentType;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }
}
