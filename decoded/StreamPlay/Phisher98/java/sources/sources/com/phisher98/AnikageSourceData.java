package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000 \n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0000\n\u0002\u0010\u000b\n\u0002\b\u0010\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B+\u0012\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0005\u0012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0007\u0010\bJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u0010\u0010\u000f\u001a\u0004\u0018\u00010\u0005HÆ\u0003¢\u0006\u0002\u0010\u000bJ\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003J2\u0010\u0011\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00052\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u0003HÆ\u0001¢\u0006\u0002\u0010\u0012J\u0014\u0010\u0013\u001a\u00020\u00052\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\nR\u0015\u0010\u0004\u001a\u0004\u0018\u00010\u0005¢\u0006\n\n\u0002\u0010\f\u001a\u0004\b\u0004\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\n¨\u0006\u0018"}, d2 = {"Lcom/phisher98/AnikageSourceData;", "", "url", "", "isM3U8", "", "embedUrl", "<init>", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "()Ljava/lang/Boolean;", "Ljava/lang/Boolean;", "getEmbedUrl", "component1", "component2", "component3", "copy", "(Ljava/lang/String;Ljava/lang/Boolean;Ljava/lang/String;)Lcom/phisher98/AnikageSourceData;", "equals", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnikageSourceData {

    @Nullable
    private final String embedUrl;

    @Nullable
    private final Boolean isM3U8;

    @Nullable
    private final String url;

    public AnikageSourceData() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ AnikageSourceData copy$default(AnikageSourceData anikageSourceData, String str, Boolean bool, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = anikageSourceData.url;
        }
        if ((i & 2) != 0) {
            bool = anikageSourceData.isM3U8;
        }
        if ((i & 4) != 0) {
            str2 = anikageSourceData.embedUrl;
        }
        return anikageSourceData.copy(str, bool, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final Boolean getIsM3U8() {
        return this.isM3U8;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getEmbedUrl() {
        return this.embedUrl;
    }

    @NotNull
    public final AnikageSourceData copy(@Nullable String url, @Nullable Boolean isM3U8, @Nullable String embedUrl) {
        return new AnikageSourceData(url, isM3U8, embedUrl);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnikageSourceData)) {
            return false;
        }
        AnikageSourceData anikageSourceData = (AnikageSourceData) other;
        return Intrinsics.areEqual(this.url, anikageSourceData.url) && Intrinsics.areEqual(this.isM3U8, anikageSourceData.isM3U8) && Intrinsics.areEqual(this.embedUrl, anikageSourceData.embedUrl);
    }

    public int hashCode() {
        return ((((this.url == null ? 0 : this.url.hashCode()) * 31) + (this.isM3U8 == null ? 0 : this.isM3U8.hashCode())) * 31) + (this.embedUrl != null ? this.embedUrl.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AnikageSourceData(url=" + this.url + ", isM3U8=" + this.isM3U8 + ", embedUrl=" + this.embedUrl + ')';
    }

    public AnikageSourceData(@Nullable String url, @Nullable Boolean isM3U8, @Nullable String embedUrl) {
        this.url = url;
        this.isM3U8 = isM3U8;
        this.embedUrl = embedUrl;
    }

    public /* synthetic */ AnikageSourceData(String str, Boolean bool, String str2, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : bool, (i & 4) != 0 ? null : str2);
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final Boolean isM3U8() {
        return this.isM3U8;
    }

    @Nullable
    public final String getEmbedUrl() {
        return this.embedUrl;
    }
}
