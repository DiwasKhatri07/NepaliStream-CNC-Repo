package com.phisher98;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SuperStreamParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/SuperStream/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0007\n\u0002\u0010\u000b\n\u0002\b\u0017\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0006\u0010\u0005\u001a\u00020\u0003\u0012\u0006\u0010\u0006\u001a\u00020\u0003\u0012\u0006\u0010\u0007\u001a\u00020\u0003\u0012\u0006\u0010\b\u001a\u00020\u0003\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u000b¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001b\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001c\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001d\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001e\u001a\u00020\u000bHÆ\u0003JY\u0010\u001f\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\b\b\u0002\u0010\u0005\u001a\u00020\u00032\b\b\u0002\u0010\u0006\u001a\u00020\u00032\b\b\u0002\u0010\u0007\u001a\u00020\u00032\b\b\u0002\u0010\b\u001a\u00020\u00032\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u000bHÆ\u0001J\u0014\u0010 \u001a\u00020\u000b2\b\u0010!\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\"\u001a\u00020#HÖ\u0081\u0004J\n\u0010$\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\u0006\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\u0007\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0015\u0010\u000fR\u0011\u0010\n\u001a\u00020\u000b¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u0016¨\u0006%"}, d2 = {"Lcom/phisher98/WyZIESUB;", "", "id", "", "url", "flagUrl", "format", "display", "language", "media", "isHearingImpaired", "", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Z)V", "getId", "()Ljava/lang/String;", "getUrl", "getFlagUrl", "getFormat", "getDisplay", "getLanguage", "getMedia", "()Z", "component1", "component2", "component3", "component4", "component5", "component6", "component7", "component8", "copy", "equals", "other", "hashCode", "", "toString", "SuperStream"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class WyZIESUB {

    @NotNull
    private final String display;

    @NotNull
    private final String flagUrl;

    @NotNull
    private final String format;

    @NotNull
    private final String id;
    private final boolean isHearingImpaired;

    @NotNull
    private final String language;

    @NotNull
    private final String media;

    @NotNull
    private final String url;

    public static /* synthetic */ WyZIESUB copy$default(WyZIESUB wyZIESUB, String str, String str2, String str3, String str4, String str5, String str6, String str7, boolean z, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wyZIESUB.id;
        }
        if ((i & 2) != 0) {
            str2 = wyZIESUB.url;
        }
        if ((i & 4) != 0) {
            str3 = wyZIESUB.flagUrl;
        }
        if ((i & 8) != 0) {
            str4 = wyZIESUB.format;
        }
        if ((i & 16) != 0) {
            str5 = wyZIESUB.display;
        }
        if ((i & 32) != 0) {
            str6 = wyZIESUB.language;
        }
        if ((i & 64) != 0) {
            str7 = wyZIESUB.media;
        }
        if ((i & 128) != 0) {
            z = wyZIESUB.isHearingImpaired;
        }
        String str8 = str7;
        boolean z2 = z;
        String str9 = str5;
        String str10 = str6;
        return wyZIESUB.copy(str, str2, str3, str4, str9, str10, str8, z2);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getId() {
        return this.id;
    }

    @NotNull
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getFlagUrl() {
        return this.flagUrl;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getFormat() {
        return this.format;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getDisplay() {
        return this.display;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    /* JADX INFO: renamed from: component7, reason: from getter */
    public final String getMedia() {
        return this.media;
    }

    /* JADX INFO: renamed from: component8, reason: from getter */
    public final boolean getIsHearingImpaired() {
        return this.isHearingImpaired;
    }

    @NotNull
    public final WyZIESUB copy(@NotNull String id, @NotNull String url, @NotNull String flagUrl, @NotNull String format, @NotNull String display, @NotNull String language, @NotNull String media, boolean isHearingImpaired) {
        return new WyZIESUB(id, url, flagUrl, format, display, language, media, isHearingImpaired);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WyZIESUB)) {
            return false;
        }
        WyZIESUB wyZIESUB = (WyZIESUB) other;
        return Intrinsics.areEqual(this.id, wyZIESUB.id) && Intrinsics.areEqual(this.url, wyZIESUB.url) && Intrinsics.areEqual(this.flagUrl, wyZIESUB.flagUrl) && Intrinsics.areEqual(this.format, wyZIESUB.format) && Intrinsics.areEqual(this.display, wyZIESUB.display) && Intrinsics.areEqual(this.language, wyZIESUB.language) && Intrinsics.areEqual(this.media, wyZIESUB.media) && this.isHearingImpaired == wyZIESUB.isHearingImpaired;
    }

    public int hashCode() {
        return (((((((((((((this.id.hashCode() * 31) + this.url.hashCode()) * 31) + this.flagUrl.hashCode()) * 31) + this.format.hashCode()) * 31) + this.display.hashCode()) * 31) + this.language.hashCode()) * 31) + this.media.hashCode()) * 31) + WyZIESUB$$ExternalSyntheticBackport0.m8m(this.isHearingImpaired);
    }

    @NotNull
    public String toString() {
        return "WyZIESUB(id=" + this.id + ", url=" + this.url + ", flagUrl=" + this.flagUrl + ", format=" + this.format + ", display=" + this.display + ", language=" + this.language + ", media=" + this.media + ", isHearingImpaired=" + this.isHearingImpaired + ')';
    }

    public WyZIESUB(@NotNull String id, @NotNull String url, @NotNull String flagUrl, @NotNull String format, @NotNull String display, @NotNull String language, @NotNull String media, boolean isHearingImpaired) {
        this.id = id;
        this.url = url;
        this.flagUrl = flagUrl;
        this.format = format;
        this.display = display;
        this.language = language;
        this.media = media;
        this.isHearingImpaired = isHearingImpaired;
    }

    @NotNull
    public final String getId() {
        return this.id;
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final String getFlagUrl() {
        return this.flagUrl;
    }

    @NotNull
    public final String getFormat() {
        return this.format;
    }

    @NotNull
    public final String getDisplay() {
        return this.display;
    }

    @NotNull
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final String getMedia() {
        return this.media;
    }

    public final boolean isHearingImpaired() {
        return this.isHearingImpaired;
    }
}
