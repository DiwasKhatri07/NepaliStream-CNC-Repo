package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/phisher98/StreamPlay/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0001\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0001\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR\u0013\u0010\u0006\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR\u0013\u0010\u0007\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/phisher98/AnichiSubtitles;", "", "lang", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "label", "src", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLang", "()Ljava/lang/String;", "getLabel", "getSrc", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class AnichiSubtitles {

    @Nullable
    private final String label;

    @Nullable
    private final String lang;

    @Nullable
    private final String src;

    public static /* synthetic */ AnichiSubtitles copy$default(AnichiSubtitles anichiSubtitles, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = anichiSubtitles.lang;
        }
        if ((i & 2) != 0) {
            str2 = anichiSubtitles.label;
        }
        if ((i & 4) != 0) {
            str3 = anichiSubtitles.src;
        }
        return anichiSubtitles.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getSrc() {
        return this.src;
    }

    @NotNull
    public final AnichiSubtitles copy(@JsonProperty("lang") @Nullable String lang, @JsonProperty("label") @Nullable String label, @JsonProperty("src") @Nullable String src) {
        return new AnichiSubtitles(lang, label, src);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof AnichiSubtitles)) {
            return false;
        }
        AnichiSubtitles anichiSubtitles = (AnichiSubtitles) other;
        return Intrinsics.areEqual(this.lang, anichiSubtitles.lang) && Intrinsics.areEqual(this.label, anichiSubtitles.label) && Intrinsics.areEqual(this.src, anichiSubtitles.src);
    }

    public int hashCode() {
        return ((((this.lang == null ? 0 : this.lang.hashCode()) * 31) + (this.label == null ? 0 : this.label.hashCode())) * 31) + (this.src != null ? this.src.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "AnichiSubtitles(lang=" + this.lang + ", label=" + this.label + ", src=" + this.src + ')';
    }

    public AnichiSubtitles(@JsonProperty("lang") @Nullable String lang, @JsonProperty("label") @Nullable String label, @JsonProperty("src") @Nullable String src) {
        this.lang = lang;
        this.label = label;
        this.src = src;
    }

    @Nullable
    public final String getLang() {
        return this.lang;
    }

    @Nullable
    public final String getLabel() {
        return this.label;
    }

    @Nullable
    public final String getSrc() {
        return this.src;
    }
}
