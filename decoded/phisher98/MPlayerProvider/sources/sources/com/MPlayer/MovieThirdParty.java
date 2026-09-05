package com.MPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001d\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BQ\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0001\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0001\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\u000b\u0010\u001d\u001a\u0004\u0018\u00010\u0001HÆ\u0003J\t\u0010\u001e\u001a\u00020\u0003HÆ\u0003Jc\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00012\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00012\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0014\u0010 \u001a\u00020!2\b\u0010\"\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010#\u001a\u00020$HÖ\u0081\u0004J\n\u0010%\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u0011R\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u0011R\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u0011R\u0013\u0010\b\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u0011R\u0013\u0010\t\u001a\u0004\u0018\u00010\u0001¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u0011R\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0016\u0010\u000e¨\u0006&"}, d2 = {"Lcom/MPlayer/MovieThirdParty;", "", "dashUrl", "", "hlsUrl", "contentId", "hlsId", "dashId", "webHlsUrl", "validUntil", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/Object;Ljava/lang/String;)V", "getDashUrl", "()Ljava/lang/String;", "getHlsUrl", "getContentId", "()Ljava/lang/Object;", "getHlsId", "getDashId", "getWebHlsUrl", "getValidUntil", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class MovieThirdParty {

    @Nullable
    private final Object contentId;

    @Nullable
    private final Object dashId;

    @NotNull
    private final String dashUrl;

    @Nullable
    private final Object hlsId;

    @NotNull
    private final String hlsUrl;

    @NotNull
    private final String name;

    @Nullable
    private final Object validUntil;

    @Nullable
    private final Object webHlsUrl;

    public static /* synthetic */ MovieThirdParty copy$default(MovieThirdParty movieThirdParty, String str, String str2, Object obj, Object obj2, Object obj3, Object obj4, Object obj5, String str3, int i, Object obj6) {
        if ((i & 1) != 0) {
            str = movieThirdParty.dashUrl;
        }
        if ((i & 2) != 0) {
            str2 = movieThirdParty.hlsUrl;
        }
        if ((i & 4) != 0) {
            obj = movieThirdParty.contentId;
        }
        if ((i & 8) != 0) {
            obj2 = movieThirdParty.hlsId;
        }
        if ((i & 16) != 0) {
            obj3 = movieThirdParty.dashId;
        }
        if ((i & 32) != 0) {
            obj4 = movieThirdParty.webHlsUrl;
        }
        if ((i & 64) != 0) {
            obj5 = movieThirdParty.validUntil;
        }
        if ((i & 128) != 0) {
            str3 = movieThirdParty.name;
        }
        Object obj7 = obj5;
        String str4 = str3;
        Object obj8 = obj3;
        Object obj9 = obj4;
        return movieThirdParty.copy(str, str2, obj, obj2, obj8, obj9, obj7, str4);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDashUrl() {
        return this.dashUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHlsUrl() {
        return this.hlsUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final Object getContentId() {
        return this.contentId;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final Object getHlsId() {
        return this.hlsId;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final Object getDashId() {
        return this.dashId;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final Object getWebHlsUrl() {
        return this.webHlsUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final Object getValidUntil() {
        return this.validUntil;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final MovieThirdParty copy(@NotNull String dashUrl, @NotNull String hlsUrl, @Nullable Object contentId, @Nullable Object hlsId, @Nullable Object dashId, @Nullable Object webHlsUrl, @Nullable Object validUntil, @NotNull String name) {
        return new MovieThirdParty(dashUrl, hlsUrl, contentId, hlsId, dashId, webHlsUrl, validUntil, name);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof MovieThirdParty)) {
            return false;
        }
        MovieThirdParty movieThirdParty = (MovieThirdParty) other;
        return Intrinsics.areEqual(this.dashUrl, movieThirdParty.dashUrl) && Intrinsics.areEqual(this.hlsUrl, movieThirdParty.hlsUrl) && Intrinsics.areEqual(this.contentId, movieThirdParty.contentId) && Intrinsics.areEqual(this.hlsId, movieThirdParty.hlsId) && Intrinsics.areEqual(this.dashId, movieThirdParty.dashId) && Intrinsics.areEqual(this.webHlsUrl, movieThirdParty.webHlsUrl) && Intrinsics.areEqual(this.validUntil, movieThirdParty.validUntil) && Intrinsics.areEqual(this.name, movieThirdParty.name);
    }

    public int hashCode() {
        return (((((((((((((this.dashUrl.hashCode() * 31) + this.hlsUrl.hashCode()) * 31) + (this.contentId == null ? 0 : this.contentId.hashCode())) * 31) + (this.hlsId == null ? 0 : this.hlsId.hashCode())) * 31) + (this.dashId == null ? 0 : this.dashId.hashCode())) * 31) + (this.webHlsUrl == null ? 0 : this.webHlsUrl.hashCode())) * 31) + (this.validUntil != null ? this.validUntil.hashCode() : 0)) * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "MovieThirdParty(dashUrl=" + this.dashUrl + ", hlsUrl=" + this.hlsUrl + ", contentId=" + this.contentId + ", hlsId=" + this.hlsId + ", dashId=" + this.dashId + ", webHlsUrl=" + this.webHlsUrl + ", validUntil=" + this.validUntil + ", name=" + this.name + ')';
    }

    public MovieThirdParty(@NotNull String dashUrl, @NotNull String hlsUrl, @Nullable Object contentId, @Nullable Object hlsId, @Nullable Object dashId, @Nullable Object webHlsUrl, @Nullable Object validUntil, @NotNull String name) {
        this.dashUrl = dashUrl;
        this.hlsUrl = hlsUrl;
        this.contentId = contentId;
        this.hlsId = hlsId;
        this.dashId = dashId;
        this.webHlsUrl = webHlsUrl;
        this.validUntil = validUntil;
        this.name = name;
    }

    @NotNull
    public final String getDashUrl() {
        return this.dashUrl;
    }

    @NotNull
    public final String getHlsUrl() {
        return this.hlsUrl;
    }

    @Nullable
    public final Object getContentId() {
        return this.contentId;
    }

    @Nullable
    public final Object getHlsId() {
        return this.hlsId;
    }

    @Nullable
    public final Object getDashId() {
        return this.dashId;
    }

    @Nullable
    public final Object getWebHlsUrl() {
        return this.webHlsUrl;
    }

    @Nullable
    public final Object getValidUntil() {
        return this.validUntil;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }
}
