package com.phisher98;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.DefaultConstructorMarker;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: StreamPlayParser.kt */
/* JADX INFO: loaded from: /home/runner/work/NepaliStream-CNC-Repo/NepaliStream-CNC-Repo/decoded/StreamPlay/Phisher98/java/classes.dex */
@Metadata(d1 = {"\u0000&\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\u0018\u0002\n\u0002\b\u000e\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001BU\u0012\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002\u0012\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006\u0012\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\u0004\b\b\u0010\tJ\u000b\u0010\u000e\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000f\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u0010\u001a\u0004\u0018\u00010\u0003HÆ\u0003JW\u0010\u0011\u001a\u00020\u00002\u0018\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00022\u0018\b\u0003\u0010\u0006\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u00062\u0018\b\u0003\u0010\u0007\u001a\u0004\u0018\u00010\u0003:\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007HÆ\u0001J\u0014\u0010\u0012\u001a\u00020\u00132\b\u0010\u0014\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0015\u001a\u00020\u0016HÖ\u0081\u0004J\n\u0010\u0017\u001a\u00020\u0003HÖ\u0081\u0004R'\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0002¢\u0006\b\n\u0000\u001a\u0004\b\n\u0010\u000bR'\u0010\u0006\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0006¢\u0006\b\n\u0000\u001a\u0004\b\f\u0010\u000bR'\u0010\u0007\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004\u0092\u0002\f\b\u0004\u0012\b\b\u0005\u0012\u0004\b\b(\u0007¢\u0006\b\n\u0000\u001a\u0004\b\r\u0010\u000b¨\u0006\u0018"}, d2 = {"Lcom/phisher98/VaplayerSub;", "", "lang", "", "Lcom/fasterxml/jackson/annotation/JsonProperty;", "value", "code", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;Ljava/lang/String;)V", "getLang", "()Ljava/lang/String;", "getCode", "getUrl", "component1", "component2", "component3", "copy", "equals", "", "other", "hashCode", "", "toString", "StreamPlay"}, k = 1, mv = {2, 4, 0}, xi = 48)
public final /* data */ class VaplayerSub {

    @JsonProperty("code")
    @Nullable
    private final String code;

    @JsonProperty("lang")
    @Nullable
    private final String lang;

    @JsonProperty("url")
    @Nullable
    private final String url;

    public VaplayerSub() {
        this(null, null, null, 7, null);
    }

    public static /* synthetic */ VaplayerSub copy$default(VaplayerSub vaplayerSub, String str, String str2, String str3, int i, Object obj) {
        if ((i & 1) != 0) {
            str = vaplayerSub.lang;
        }
        if ((i & 2) != 0) {
            str2 = vaplayerSub.code;
        }
        if ((i & 4) != 0) {
            str3 = vaplayerSub.url;
        }
        return vaplayerSub.copy(str, str2, str3);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getLang() {
        return this.lang;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getCode() {
        return this.code;
    }

    @Nullable
    /* JADX INFO: renamed from: component3, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final VaplayerSub copy(@JsonProperty("lang") @Nullable String lang, @JsonProperty("code") @Nullable String code, @JsonProperty("url") @Nullable String url) {
        return new VaplayerSub(lang, code, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof VaplayerSub)) {
            return false;
        }
        VaplayerSub vaplayerSub = (VaplayerSub) other;
        return Intrinsics.areEqual(this.lang, vaplayerSub.lang) && Intrinsics.areEqual(this.code, vaplayerSub.code) && Intrinsics.areEqual(this.url, vaplayerSub.url);
    }

    public int hashCode() {
        return ((((this.lang == null ? 0 : this.lang.hashCode()) * 31) + (this.code == null ? 0 : this.code.hashCode())) * 31) + (this.url != null ? this.url.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "VaplayerSub(lang=" + this.lang + ", code=" + this.code + ", url=" + this.url + ')';
    }

    public VaplayerSub(@JsonProperty("lang") @Nullable String lang, @JsonProperty("code") @Nullable String code, @JsonProperty("url") @Nullable String url) {
        this.lang = lang;
        this.code = code;
        this.url = url;
    }

    public /* synthetic */ VaplayerSub(String str, String str2, String str3, int i, DefaultConstructorMarker defaultConstructorMarker) {
        this((i & 1) != 0 ? null : str, (i & 2) != 0 ? null : str2, (i & 4) != 0 ? null : str3);
    }

    @Nullable
    public final String getLang() {
        return this.lang;
    }

    @Nullable
    public final String getCode() {
        return this.code;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }
}
