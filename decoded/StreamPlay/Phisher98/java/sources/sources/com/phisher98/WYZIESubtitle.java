package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BS\u0012\u0016\b\u0001\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\t\u0010\u000e\u001a\u00020\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JU\u0010\u0011\u001a\u00020\u00002\u0016\b\u0003\u0010\u0002\u001a\u00020\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R%\u0010\u0002\u001a\u00020\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR'\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/phisher98/WYZIESubtitle;", "", "url", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "display", "language", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getUrl", "()Ljava/lang/String;", "getDisplay", "getLanguage", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class WYZIESubtitle {

    @JsonProperty("display")
    @Nullable
    private final String display;

    @JsonProperty("language")
    @Nullable
    private final String language;

    @JsonProperty("url")
    @NotNull
    private final String url;

    public static /* synthetic */ WYZIESubtitle copy$default(WYZIESubtitle wYZIESubtitle, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wYZIESubtitle.url;
        }
        if ((i & 2) != 0) {
            str2 = wYZIESubtitle.display;
        }
        if ((i & 4) != 0) {
            str3 = wYZIESubtitle.language;
        }
        return wYZIESubtitle.copy(str, str2, str3);
    }

    @NotNull
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getDisplay() {
        return this.display;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getLanguage() {
        return this.language;
    }

    @NotNull
    public final WYZIESubtitle copy(@JsonProperty("url") @NotNull String url, @JsonProperty("display") @Nullable String display, @JsonProperty("language") @Nullable String language) {
        return new WYZIESubtitle(url, display, language);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WYZIESubtitle)) {
            return false;
        }
        WYZIESubtitle wYZIESubtitle = (WYZIESubtitle) other;
        return Intrinsics.areEqual(this.url, wYZIESubtitle.url) && Intrinsics.areEqual(this.display, wYZIESubtitle.display) && Intrinsics.areEqual(this.language, wYZIESubtitle.language);
    }

    public int hashCode() {
        return (((this.url.hashCode() * 31) + (this.display == null ? 0 : this.display.hashCode())) * 31) + (this.language != null ? this.language.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "WYZIESubtitle(url=" + this.url + ", display=" + this.display + ", language=" + this.language + ')';
    }

    public WYZIESubtitle(@JsonProperty("url") @NotNull String url, @JsonProperty("display") @Nullable String display, @JsonProperty("language") @Nullable String language) {
        this.url = url;
        this.display = display;
        this.language = language;
    }

    public /* synthetic */ WYZIESubtitle(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this(str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @NotNull
    public final String getUrl() {
        return this.url;
    }

    @Nullable
    public final String getDisplay() {
        return this.display;
    }

    @Nullable
    public final String getLanguage() {
        return this.language;
    }
}
