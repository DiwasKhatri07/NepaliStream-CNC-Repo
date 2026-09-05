package com.hdo;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SubUtils.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/HDOProvider/CNCVerse/java/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/hdo/SubtitleItem;", "", "lang", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getLang", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "HDOProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SubtitleItem {

    @JsonProperty("lang")
    @Nullable
    private final String lang;

    @JsonProperty("url")
    @Nullable
    private final String url;

    public static /* synthetic */ SubtitleItem copy$default(SubtitleItem subtitleItem, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = subtitleItem.lang;
        }
        if ((i & 2) != 0) {
            str2 = subtitleItem.url;
        }
        return subtitleItem.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final SubtitleItem copy(@JsonProperty("lang") @Nullable String lang, @JsonProperty("url") @Nullable String url) {
        return new SubtitleItem(lang, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SubtitleItem)) {
            return false;
        }
        SubtitleItem subtitleItem = (SubtitleItem) other;
        return Intrinsics.areEqual(this.lang, subtitleItem.lang) && Intrinsics.areEqual(this.url, subtitleItem.url);
    }

    public int hashCode() {
        return ((this.lang == null ? 0 : this.lang.hashCode()) * 31) + (this.url != null ? this.url.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SubtitleItem(lang=" + this.lang + ", url=" + this.url + ')';
    }

    public SubtitleItem(@JsonProperty("lang") @Nullable String lang, @JsonProperty("url") @Nullable String url) {
        this.lang = lang;
        this.url = url;
    }

    @Nullable
    public final String getLang() {
        return this.lang;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }
}
