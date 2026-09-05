package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000*\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\u0002\n\u0002\u0018\u0002\n\u0002\b\u0016\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BG\u0012\u0006\u0010\u0002\u001a\u00020\u0003\u0012\u0006\u0010\u0004\u001a\u00020\u0003\u0012\u0016\b\u0001\u0010\u0005\u001a\u00020\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b\u0012\u0006\u0010\t\u001a\u00020\u0003\u0012\u0006\u0010\n\u001a\u00020\u0003\u0012\u0006\u0010\u000b\u001a\u00020\u0003¢\u0006\u0004\b\f\u0010\rJ\t\u0010\u0015\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0016\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0017\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0018\u001a\u00020\u0003HÆ\u0003J\t\u0010\u0019\u001a\u00020\u0003HÆ\u0003J\t\u0010\u001a\u001a\u00020\u0003HÆ\u0003JS\u0010\u001b\u001a\u00020\u00002\b\b\u0002\u0010\u0002\u001a\u00020\u00032\b\b\u0002\u0010\u0004\u001a\u00020\u00032\u0016\b\u0003\u0010\u0005\u001a\u00020\u0003:\f\b\u0006\u0012\b\b\u0007\u0012\u0004\b\b(\b2\b\b\u0002\u0010\t\u001a\u00020\u00032\b\b\u0002\u0010\n\u001a\u00020\u00032\b\b\u0002\u0010\u000b\u001a\u00020\u0003HÆ\u0001J\u0014\u0010\u001c\u001a\u00020\u001d2\b\u0010\u001e\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u001f\u001a\u00020 HÖ\u0081\u0004J\n\u0010!\u001a\u00020\u0003HÖ\u0081\u0004R\u0011\u0010\u0002\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u000e\u0010\u000fR\u0011\u0010\u0004\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0010\u0010\u000fR\u0011\u0010\u0005\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0011\u0010\u000fR\u0011\u0010\t\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0012\u0010\u000fR\u0011\u0010\n\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0013\u0010\u000fR\u0011\u0010\u000b\u001a\u00020\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0014\u0010\u000f¨\u0006\""}, d2 = {"Lcom/phisher98/Subtitle;", "", "id", "", "url", "subEncoding", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "SubEncoding", "lang", "m", "g", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getId", "()Ljava/lang/String;", "getUrl", "getSubEncoding", "getLang", "getM", "getG", "component1", "component2", "component3", "component4", "component5", "component6", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class Subtitle {

    @NotNull
    private final String g;

    @NotNull
    private final String id;

    @NotNull
    private final String lang;

    @NotNull
    private final String m;

    @NotNull
    private final String subEncoding;

    @NotNull
    private final String url;

    public static /* synthetic */ Subtitle copy$default(Subtitle subtitle, String str, String str2, String str3, String str4, String str5, String str6, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subtitle.id;
        }
        if ((i & 2) != 0) {
            str2 = subtitle.url;
        }
        if ((i & 4) != 0) {
            str3 = subtitle.subEncoding;
        }
        if ((i & 8) != 0) {
            str4 = subtitle.lang;
        }
        if ((i & 16) != 0) {
            str5 = subtitle.m;
        }
        if ((i & 32) != 0) {
            str6 = subtitle.g;
        }
        String str7 = str5;
        String str8 = str6;
        return subtitle.copy(str, str2, str3, str4, str7, str8);
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
    public final String getSubEncoding() {
        return this.subEncoding;
    }

    @NotNull
    /* JADX INFO: renamed from: component4, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    @NotNull
    /* JADX INFO: renamed from: component5, reason: from getter */
    public final String getM() {
        return this.m;
    }

    @NotNull
    /* JADX INFO: renamed from: component6, reason: from getter */
    public final String getG() {
        return this.g;
    }

    @NotNull
    public final Subtitle copy(@NotNull String id, @NotNull String url, @JsonProperty("SubEncoding") @NotNull String subEncoding, @NotNull String lang, @NotNull String m, @NotNull String g) {
        return new Subtitle(id, url, subEncoding, lang, m, g);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof Subtitle)) {
            return false;
        }
        Subtitle subtitle = (Subtitle) other;
        return Intrinsics.areEqual(this.id, subtitle.id) && Intrinsics.areEqual(this.url, subtitle.url) && Intrinsics.areEqual(this.subEncoding, subtitle.subEncoding) && Intrinsics.areEqual(this.lang, subtitle.lang) && Intrinsics.areEqual(this.m, subtitle.m) && Intrinsics.areEqual(this.g, subtitle.g);
    }

    public int hashCode() {
        return (((((((((this.id.hashCode() * 31) + this.url.hashCode()) * 31) + this.subEncoding.hashCode()) * 31) + this.lang.hashCode()) * 31) + this.m.hashCode()) * 31) + this.g.hashCode();
    }

    @NotNull
    public String toString() {
        return "Subtitle(id=" + this.id + ", url=" + this.url + ", subEncoding=" + this.subEncoding + ", lang=" + this.lang + ", m=" + this.m + ", g=" + this.g + ')';
    }

    public Subtitle(@NotNull String id, @NotNull String url, @JsonProperty("SubEncoding") @NotNull String subEncoding, @NotNull String lang, @NotNull String m, @NotNull String g) {
        this.id = id;
        this.url = url;
        this.subEncoding = subEncoding;
        this.lang = lang;
        this.m = m;
        this.g = g;
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
    public final String getSubEncoding() {
        return this.subEncoding;
    }

    @NotNull
    public final String getLang() {
        return this.lang;
    }

    @NotNull
    public final String getM() {
        return this.m;
    }

    @NotNull
    public final String getG() {
        return this.g;
    }
}
