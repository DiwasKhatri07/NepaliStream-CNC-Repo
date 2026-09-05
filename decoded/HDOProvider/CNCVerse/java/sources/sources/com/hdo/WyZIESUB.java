package com.hdo;

import com.fasterxml.jackson.annotation.JsonProperty;
import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SubUtils.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/HDOProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001f\u0012\n\b\u0001\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\n\b\u0001\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0003\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0003\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0018\u0010\u0002\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0018\u0010\u0004\u001a\u0004\u0018\u00010\u00038\u0006X\u0087\u0004¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/hdo/WyZIESUB;", "", "display", "", "url", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getDisplay", "()Ljava/lang/String;", "getUrl", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "HDOProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class WyZIESUB {

    @JsonProperty("display")
    @Nullable
    private final String display;

    @JsonProperty("url")
    @Nullable
    private final String url;

    public static /* synthetic */ WyZIESUB copy$default(WyZIESUB wyZIESUB, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = wyZIESUB.display;
        }
        if ((i & 2) != 0) {
            str2 = wyZIESUB.url;
        }
        return wyZIESUB.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getDisplay() {
        return this.display;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getUrl() {
        return this.url;
    }

    @NotNull
    public final WyZIESUB copy(@JsonProperty("display") @Nullable String display, @JsonProperty("url") @Nullable String url) {
        return new WyZIESUB(display, url);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof WyZIESUB)) {
            return false;
        }
        WyZIESUB wyZIESUB = (WyZIESUB) other;
        return Intrinsics.areEqual(this.display, wyZIESUB.display) && Intrinsics.areEqual(this.url, wyZIESUB.url);
    }

    public int hashCode() {
        return ((this.display == null ? 0 : this.display.hashCode()) * 31) + (this.url != null ? this.url.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "WyZIESUB(display=" + this.display + ", url=" + this.url + ')';
    }

    public WyZIESUB(@JsonProperty("display") @Nullable String display, @JsonProperty("url") @Nullable String url) {
        this.display = display;
        this.url = url;
    }

    @Nullable
    public final String getDisplay() {
        return this.display;
    }

    @Nullable
    public final String getUrl() {
        return this.url;
    }
}
