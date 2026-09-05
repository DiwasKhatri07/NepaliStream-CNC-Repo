package com.MPlayer;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: Parser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/MPlayerProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u001c\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0005\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0006\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0007\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\b\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\t\u001a\u0004\u0018\u00010\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003¢\u0006\u0004\b\u000b\u0010\fJ\u000b\u0010\u0016\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0017\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0018\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0019\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001a\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u001c\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003Jg\u0010\u001e\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0005\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0006\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0007\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\b\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\t\u001a\u0004\u0018\u00010\u00032\b\b\u0002\u0010\n\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001f\u001a\u00020 2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000eR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000f\u0010\u000eR\u0013\u0010\u0005\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000eR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000eR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000eR\u0013\u0010\b\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000eR\u0013\u0010\t\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000eR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000e¨\u0006%"}, d2 = {"Lcom/MPlayer/ThirdParty;", "", "dashUrl", "", "hlsUrl", "contentId", "hlsId", "dashId", "webHlsUrl", "validUntil", "name", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getDashUrl", "()Ljava/lang/String;", "getHlsUrl", "getContentId", "getHlsId", "getDashId", "getWebHlsUrl", "getValidUntil", "getName", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "", "other", "hashCode", "", "toString", "MPlayerProvider"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class ThirdParty {

    @Nullable
    private final String contentId;

    @Nullable
    private final String dashId;

    @Nullable
    private final String dashUrl;

    @Nullable
    private final String hlsId;

    @Nullable
    private final String hlsUrl;

    @NotNull
    private final String name;

    @Nullable
    private final String validUntil;

    @Nullable
    private final String webHlsUrl;

    public static /* synthetic */ ThirdParty copy$default(ThirdParty thirdParty, String str, String str2, String str3, String str4, String str5, String str6, String str7, String str8, int i, Object obj) {
        if ((i & 1) != 0) {
            str = thirdParty.dashUrl;
        }
        if ((i & 2) != 0) {
            str2 = thirdParty.hlsUrl;
        }
        if ((i & 4) != 0) {
            str3 = thirdParty.contentId;
        }
        if ((i & 8) != 0) {
            str4 = thirdParty.hlsId;
        }
        if ((i & 16) != 0) {
            str5 = thirdParty.dashId;
        }
        if ((i & 32) != 0) {
            str6 = thirdParty.webHlsUrl;
        }
        if ((i & 64) != 0) {
            str7 = thirdParty.validUntil;
        }
        if ((i & 128) != 0) {
            str8 = thirdParty.name;
        }
        String str9 = str7;
        String str10 = str8;
        String str11 = str5;
        String str12 = str6;
        return thirdParty.copy(str, str2, str3, str4, str11, str12, str9, str10);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDashUrl() {
        return this.dashUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getHlsUrl() {
        return this.hlsUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getContentId() {
        return this.contentId;
    }

    @Nullable
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getHlsId() {
        return this.hlsId;
    }

    @Nullable
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDashId() {
        return this.dashId;
    }

    @Nullable
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getWebHlsUrl() {
        return this.webHlsUrl;
    }

    @Nullable
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getValidUntil() {
        return this.validUntil;
    }

    @NotNull
    /* JADX INFO: renamed from: component8, reason: from getter */
    public final String getName() {
        return this.name;
    }

    @NotNull
    public final ThirdParty copy(@Nullable String dashUrl, @Nullable String hlsUrl, @Nullable String contentId, @Nullable String hlsId, @Nullable String dashId, @Nullable String webHlsUrl, @Nullable String validUntil, @NotNull String name) {
        return new ThirdParty(dashUrl, hlsUrl, contentId, hlsId, dashId, webHlsUrl, validUntil, name);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof ThirdParty)) {
            return false;
        }
        ThirdParty thirdParty = (ThirdParty) other;
        return Intrinsics.areEqual(this.dashUrl, thirdParty.dashUrl) && Intrinsics.areEqual(this.hlsUrl, thirdParty.hlsUrl) && Intrinsics.areEqual(this.contentId, thirdParty.contentId) && Intrinsics.areEqual(this.hlsId, thirdParty.hlsId) && Intrinsics.areEqual(this.dashId, thirdParty.dashId) && Intrinsics.areEqual(this.webHlsUrl, thirdParty.webHlsUrl) && Intrinsics.areEqual(this.validUntil, thirdParty.validUntil) && Intrinsics.areEqual(this.name, thirdParty.name);
    }

    public int hashCode() {
        return ((((((((((((((this.dashUrl == null ? 0 : this.dashUrl.hashCode()) * 31) + (this.hlsUrl == null ? 0 : this.hlsUrl.hashCode())) * 31) + (this.contentId == null ? 0 : this.contentId.hashCode())) * 31) + (this.hlsId == null ? 0 : this.hlsId.hashCode())) * 31) + (this.dashId == null ? 0 : this.dashId.hashCode())) * 31) + (this.webHlsUrl == null ? 0 : this.webHlsUrl.hashCode())) * 31) + (this.validUntil != null ? this.validUntil.hashCode() : 0)) * 31) + this.name.hashCode();
    }

    @NotNull
    public String toString() {
        return "ThirdParty(dashUrl=" + this.dashUrl + ", hlsUrl=" + this.hlsUrl + ", contentId=" + this.contentId + ", hlsId=" + this.hlsId + ", dashId=" + this.dashId + ", webHlsUrl=" + this.webHlsUrl + ", validUntil=" + this.validUntil + ", name=" + this.name + ')';
    }

    public ThirdParty(@Nullable String dashUrl, @Nullable String hlsUrl, @Nullable String contentId, @Nullable String hlsId, @Nullable String dashId, @Nullable String webHlsUrl, @Nullable String validUntil, @NotNull String name) {
        this.dashUrl = dashUrl;
        this.hlsUrl = hlsUrl;
        this.contentId = contentId;
        this.hlsId = hlsId;
        this.dashId = dashId;
        this.webHlsUrl = webHlsUrl;
        this.validUntil = validUntil;
        this.name = name;
    }

    @Nullable
    public final String getDashUrl() {
        return this.dashUrl;
    }

    @Nullable
    public final String getHlsUrl() {
        return this.hlsUrl;
    }

    @Nullable
    public final String getContentId() {
        return this.contentId;
    }

    @Nullable
    public final String getHlsId() {
        return this.hlsId;
    }

    @Nullable
    public final String getDashId() {
        return this.dashId;
    }

    @Nullable
    public final String getWebHlsUrl() {
        return this.webHlsUrl;
    }

    @Nullable
    public final String getValidUntil() {
        return this.validUntil;
    }

    @NotNull
    public final String getName() {
        return this.name;
    }
}
