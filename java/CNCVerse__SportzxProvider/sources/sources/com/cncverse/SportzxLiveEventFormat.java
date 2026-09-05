package com.cncverse;

import kotlin.Metadata;
import kotlin.jvm.internal.Intrinsics;
import org.jetbrains.annotations.NotNull;
import org.jetbrains.annotations.Nullable;

/* JADX INFO: compiled from: SportzxProviderManager.kt */
/* JADX INFO: loaded from: /home/ubuntu/work/NepaliStream-CNC-Repo/decoded/cncverse/SportzxProvider/classes.dex */
@Metadata(d1 = {"\u0000\"\n\u0002\u0018\u0002\n\u0002\u0010\u0000\n\u0000\n\u0002\u0010\u000e\n\u0002\b\n\n\u0002\u0010\u000b\n\u0002\b\u0002\n\u0002\u0010\b\n\u0002\b\u0002\b\u0086\b\u0018\u00002\u00020\u0001B\u001b\u0012\b\u0010\u0002\u001a\u0004\u0018\u00010\u0003\u0012\b\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\u0004\b\u0005\u0010\u0006J\u000b\u0010\n\u001a\u0004\u0018\u00010\u0003HÆ\u0003J\u000b\u0010\u000b\u001a\u0004\u0018\u00010\u0003HÆ\u0003J!\u0010\f\u001a\u00020\u00002\n\b\u0002\u0010\u0002\u001a\u0004\u0018\u00010\u00032\n\b\u0002\u0010\u0004\u001a\u0004\u0018\u00010\u0003HÆ\u0001J\u0014\u0010\r\u001a\u00020\u000e2\b\u0010\u000f\u001a\u0004\u0018\u00010\u0001HÖ\u0083\u0004J\n\u0010\u0010\u001a\u00020\u0011HÖ\u0081\u0004J\n\u0010\u0012\u001a\u00020\u0003HÖ\u0081\u0004R\u0013\u0010\u0002\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\u0007\u0010\bR\u0013\u0010\u0004\u001a\u0004\u0018\u00010\u0003¢\u0006\b\n\u0000\u001a\u0004\b\t\u0010\b¨\u0006\u0013"}, d2 = {"Lcom/cncverse/SportzxLiveEventFormat;", "", "title", "", "logo", "<init>", "(Ljava/lang/String;Ljava/lang/String;)V", "getTitle", "()Ljava/lang/String;", "getLogo", "component1", "component2", "copy", "equals", "", "other", "hashCode", "", "toString", "SportzxProvider_debug"}, k = 1, mv = {2, 3, 0}, xi = 48)
public final /* data */ class SportzxLiveEventFormat {

    @Nullable
    private final String logo;

    @Nullable
    private final String title;

    public static /* synthetic */ SportzxLiveEventFormat copy$default(SportzxLiveEventFormat sportzxLiveEventFormat, String str, String str2, int i, Object obj) {
        if ((i & 1) != 0) {
            str = sportzxLiveEventFormat.title;
        }
        if ((i & 2) != 0) {
            str2 = sportzxLiveEventFormat.logo;
        }
        return sportzxLiveEventFormat.copy(str, str2);
    }

    @Nullable
    /* JADX INFO: renamed from: component1, reason: from getter */
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    /* JADX INFO: renamed from: component2, reason: from getter */
    public final String getLogo() {
        return this.logo;
    }

    @NotNull
    public final SportzxLiveEventFormat copy(@Nullable String title, @Nullable String logo) {
        return new SportzxLiveEventFormat(title, logo);
    }

    public boolean equals(@Nullable Object other) {
        if (this == other) {
            return true;
        }
        if (!(other instanceof SportzxLiveEventFormat)) {
            return false;
        }
        SportzxLiveEventFormat sportzxLiveEventFormat = (SportzxLiveEventFormat) other;
        return Intrinsics.areEqual(this.title, sportzxLiveEventFormat.title) && Intrinsics.areEqual(this.logo, sportzxLiveEventFormat.logo);
    }

    public int hashCode() {
        return ((this.title == null ? 0 : this.title.hashCode()) * 31) + (this.logo != null ? this.logo.hashCode() : 0);
    }

    @NotNull
    public String toString() {
        return "SportzxLiveEventFormat(title=" + this.title + ", logo=" + this.logo + ')';
    }

    public SportzxLiveEventFormat(@Nullable String title, @Nullable String logo) {
        this.title = title;
        this.logo = logo;
    }

    @Nullable
    public final String getTitle() {
        return this.title;
    }

    @Nullable
    public final String getLogo() {
        return this.logo;
    }
}
